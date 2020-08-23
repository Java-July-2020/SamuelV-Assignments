package com.samuelvaldes.authentication.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	// I) Class Attributes
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	private Long id;
	
	@Column
	@NotBlank (message = "Field cannot be empty")
    private String email;
	
	@Column
	@NotBlank (message = "Field cannot be empty")
    private String password;
    
	@Transient
	@NotBlank (message = "Field cannot be empty")
    private String passwordConfirmation;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
	// II) Class Constructor Methods
	
    public User() {
    }

    // III) Getter and Setters Methods
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
