package com.samuelvaldes.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	
	// I) Class Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "Field cannot be empty")
    private String title;
    @Column
    @NotBlank(message = "Field cannot be empty")
    private String artist;
    @Column
    @Min(value = 1, message="ratting must be between 1 and 10")
    @Max(value = 10, message="ratting must be between 1 and 10")
    private int rating;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;


	//II) Class Constructor Methods

	public Song() {
	}
	
	public Song(String title, String artist, int rating) {
	    this.title = title;
	    this.artist = artist;
	    this.rating = rating;
	}
	
	// III) Getter and Setters Methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
