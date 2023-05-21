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
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="doctors")
public class Doctor {

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
    @Min(6)
    private Integer phone;
    
    @NotEmpty(message="address is required!")
    private String address;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name="clinic_id")
    private Clinic clinic;
    
    @OneToMany(mappedBy="doctor", fetch = FetchType.LAZY)
    private List<Appointment> appointments;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "doctors_patients", 
//        joinColumns = @JoinColumn(name = "doctor_id"), 
//        inverseJoinColumns = @JoinColumn(name = "patient_id")
//    )
//    private List<Patient> patient;

    

    
  

    
    
    
    public Doctor() {}
    
    
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	public Clinic getClinic() {
		return clinic;
	}


	

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
