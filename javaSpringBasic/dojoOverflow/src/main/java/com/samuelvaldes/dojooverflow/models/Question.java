package com.samuelvaldes.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {

	// I) Class Attributes
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    @NotBlank (message = "Field cannot be empty")
	private String questionText;

    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    
    @OneToMany(mappedBy="question",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    
    @Transient
	@Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
	private String parsedTags;
    
    
    // II) Class Constructor Methods
    
    public Question() {
        
    }
    
    public Question(String questionText, List<Tag> tags) {
    	this.questionText = questionText;
		this.tags = tags;
    }
    
    // III) Customized Methods
    
    
    public String[] splitTags() {
		return this.parsedTags.split("\\s*,\\s*");
	}
    
    // IV) Getter and Setters Methods

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public List<Tag> getTags() {
		return tags;
	}


	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
	
	public String getParsedTags() {
		return parsedTags;
	}

	public void setParsedTags(String parsedTags) {
		this.parsedTags = parsedTags;
	}
	
	// V) Lifecycle Callback Methods
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
