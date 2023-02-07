package com.virtusa.hotelreserve.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "BookingDetails ")
public class Booking 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
//	private String bookedFrom;
//	private String bookedTo;
	private int numberOfAdults;
	private int numberOfChildren;
	@Column(name = "Booking_Price")
	private long price;
	@Column(name = "Booking_Status")
	private String bookingStatus;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "Booking_Date")
	private LocalDate bookingDate;
	
	@OneToOne
	private Hotel hotel;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	@JsonIgnore
    @OneToOne
    private Payment payment;
	
    @JsonIgnore
    @OneToOne
    private Room room;
    
    public Booking()
    {
    	super();
    }
    
	public Booking(int bookingId, int numberOfAdults, int numberOfChildren, long price, String bookingStatus,
			LocalDate bookingDate, Customer customer, Payment payment, Room room) {
		super();
		this.bookingId = bookingId;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.price = price;
		this.bookingStatus = bookingStatus;
		this.bookingDate = bookingDate;
		this.customer = customer;
		this.payment = payment;
		this.room = room;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", numberOfAdults=" + numberOfAdults + ", numberOfChildren="
				+ numberOfChildren + ", price=" + price + ", bookingStatus=" + bookingStatus + ", bookingDate="
				+ bookingDate + ", customer=" + customer + ", payment=" + payment + ", room=" + room + "]";
	}
    
}
