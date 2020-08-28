package com.samuelvaldes.tvshows.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="shows")
public class Show {

	// I) Class Attributes
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long id;
	
	@Column(unique=true)
    @NotBlank (message = "Field cannot be empty")
	private String name;
	
    @Column
	@NotBlank (message = "Field cannot be empty")
    private String network;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;
    
    @OneToMany(mappedBy="showRated",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "show_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> usersAlreadyRate;
    
    // II) Class Constructor Methods
    
    public Show() {

	}
    
    // III) Customized Methods
    
    public Double getAverageRating() {
    	List<Rating> showRatings = this.getRatings();
    	Double sumRating = 0.0;
    	int n = this.getRatings().size();
    	for (Rating eachRating : showRatings) {
    		sumRating = sumRating + eachRating.getScore();
    	}
    	Double avgRating = sumRating/n;
    	return avgRating;
	}

    // IV) Getter and Setters Methods
    
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<User> getUsersAlreadyRate() {
		return usersAlreadyRate;
	}

	public void setUsersAlreadyRate(List<User> usersAlreadyRate) {
		this.usersAlreadyRate = usersAlreadyRate;
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
