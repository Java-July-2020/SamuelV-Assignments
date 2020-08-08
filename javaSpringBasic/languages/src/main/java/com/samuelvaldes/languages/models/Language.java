package com.samuelvaldes.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {

	// I) Class Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 2, max = 20, message = "Field should have between 2 and 20 characters")
    private String name;
    @Column
    @Size(min = 2, max = 20, message = "Field should have between 2 and 20 characters")
    private String creator;
    @Column
    @NotBlank(message = "Field cannot be empty")
    private String version;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    // II) Class Constructor Methods
    
    public Language() {
    }
    
    public Language(String name,  String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
    
 // III) Getter and Setters Methods
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	
// IV) Lifecycle Callback Methods
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
   
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
