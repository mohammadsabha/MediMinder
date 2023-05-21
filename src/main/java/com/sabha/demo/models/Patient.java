package com.sabha.demo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="name is required!")
    @Size(min=3, max=30, message="full name must be between 10 and 50 characters")
    private String name;
    


    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="phone is required!")
    @Min(10)
    private String phone;
    

    private Date date;
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="doctor_id")
//    private Doctor doctor;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "doctors_patients", 
//        joinColumns = @JoinColumn(name = "patient_id"), 
//        inverseJoinColumns = @JoinColumn(name = "doctor_id")
//    )
//    private List<Doctor> doctor;
    
    @OneToMany(mappedBy="patient", fetch = FetchType.LAZY)
    private List<Appointment> appointments;
    

    
    public Patient() {}
    
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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



	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
}
