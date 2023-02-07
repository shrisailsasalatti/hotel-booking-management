package com.virtusa.hotelreserve.bookingservice;

import java.time.LocalDate;
import java.util.List;

import com.virtusa.hotelreserve.entity.Booking;

public interface BookingService {
public boolean addBooking(Booking booking); 
	
	public Booking getBookingDetailsById(int bookingId);

	public List<Booking> getAllBookingDetails();

	public void deleteBookingById(int id);

	public List<Booking> getBookingDetailsByDate(LocalDate date);
}
