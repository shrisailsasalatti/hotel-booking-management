package com.virtusa.hotelreserve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Upi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	
	@Column(name = "Upi_ID")
	private String upiId;
	
	
	private int upiPin;
	
	public Upi()
	{
		super();
	}

	public Upi(int uId, String upiId, int upiPin) {
		super();
		this.uId = uId;
		this.upiId = upiId;
		this.upiPin = upiPin;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public int getUpiPin() {
		return upiPin;
	}

	public void setUpiPin(int upiPin) {
		this.upiPin = upiPin;
	}
	


}
