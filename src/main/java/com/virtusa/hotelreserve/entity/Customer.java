package com.virtusa.hotelreserve.entity;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id")
	private int customerId;
	
	@Column(name = "Customer_Name")
	private String userName;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name="DateOfBirth")
	private LocalDate dob;
	
	@Column(name = "Email_ID")
	private String emailId;
	
	@Column(name = "Mobile_Number")
	private long mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@JsonIgnore
	@OneToMany
	private List<Booking> bookings;
	@JsonIgnore
	@OneToOne
	private User user;
	
	public Customer()
	{
		super();
	}
	public Customer(int customerId, String userName, String password, LocalDate dob, String emailId, long mobileNumber,
			Address address, User user) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.user = user;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", password=" + password + ", dob="
				+ dob + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", address=" + address + ", user="
				+ user + "]";
	}

	

	
}