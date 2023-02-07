package com.virtusa.hotelreserve.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Admin_Id")
	private int adminId;
	
	@Column(name = "Admin_Name")
	private String userName;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name="DateOfBirth")
	private LocalDate dob;
	
	@Column(name = "Email_ID")
	private String emailId;
	
	@Column(name = "Mobile_Number")
	private long mobileNumber;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//private Address address;
	//@OneToOne
	//private User user;

	public Admin()
	{
		super();
	}

	
		
	

	public Admin(int adminId, String userName, String password, LocalDate dob, String emailId, long mobileNumber) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}





	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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





	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", dob=" + dob
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + "]";
	}



	


	
}

