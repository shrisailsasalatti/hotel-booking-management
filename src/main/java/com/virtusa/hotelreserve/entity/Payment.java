package com.virtusa.hotelreserve.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	paymentId;
	
	
	private String paymentType;
	
	
	@Enumerated(EnumType.STRING)
	
	private	Status paymentStatus;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private	LocalDateTime paymentTime;
	
	
	private double paymentAmount;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Card card;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Upi upi;
	
	public Payment()
	{
		super();
	}

	public Payment(int paymentId, String paymentType, Status paymentStatus, LocalDate paymentDate,
			LocalDateTime paymentTime, double paymentAmount, Card card, Upi upi) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.paymentAmount = paymentAmount;
		this.card = card;
		this.upi = upi;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Status getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Upi getUpi() {
		return upi;
	}

	public void setUpi(Upi upi) {
		this.upi = upi;
	}
	
	
	@JsonIgnore
	public String getCardNumber() 
	{
		if(card==null)
		card=new Card();
		return card.getCardNumber();
		
	}

	@JsonIgnore
	public int getCvv() 
	{
		if(card==null)
		card=new Card();
		return card.getCvv();
		
	}

	@JsonIgnore
	public String getUpiId() 
	{
		if(upi==null)
		upi=new Upi();
		return upi.getUpiId();
		
	}
	
	@JsonIgnore
	public int getUpiPin() 
	{
		if(upi==null)
		upi=new Upi();
		return upi.getUpiPin();
		
	}
	
}