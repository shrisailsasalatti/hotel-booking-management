package com.virtusa.hotelreserve.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class MetaPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int metaId;
	
	
	@JsonIgnore
	@OneToOne
	private Customer customer;
	
	
	//---------- Card Details ----------
	@Column(name = "Card_HolderName")
	private String cardHolderName;
	
	
	@Column(unique = true)
	private String cardNumber;
	
	@Column(name = "Card_Cvv",unique = true)
	private int cvv;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "Card_ExpiryDate")
	private	LocalDate cardExpiry;
	
	
	//---------- UPI Details ----------
	@Column(name = "Upi_Id",unique = true)
	private String upiId;
	
	@Column(name = "Upi_PIN")
	private int upiPin;
	


	
	public  MetaPayment()
	{
		super();
	}




	public MetaPayment(int metaId, Customer customer, String cardHolderName, String cardNumber, int cvv,
			LocalDate cardExpiry, String upiId, int upiPin) {
		super();
		this.metaId = metaId;
		this.customer = customer;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.cardExpiry = cardExpiry;
		this.upiId = upiId;
		this.upiPin = upiPin;
	}




	public int getMetaId() {
		return metaId;
	}




	public void setMetaId(int metaId) {
		this.metaId = metaId;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	public String getCardHolderName() {
		return cardHolderName;
	}




	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}




	public String getCardNumber() {
		return cardNumber;
	}




	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}




	public int getCvv() {
		return cvv;
	}




	public void setCvv(int cvv) {
		this.cvv = cvv;
	}




	public LocalDate getCardExpiry() {
		return cardExpiry;
	}




	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
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
	
	@JsonIgnore
	public int getCustomerId()
	{
		if(customer==null)
		customer=new Customer();
		return customer.getCustomerId();
	}
}
