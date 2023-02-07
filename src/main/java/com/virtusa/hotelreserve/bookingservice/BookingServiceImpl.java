package com.virtusa.hotelreserve.bookingservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.bookingrepository.BookingRepository;
import com.virtusa.hotelreserve.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public boolean addBooking(Booking booking) 
	{

		if(1>0)
		{
		bookingRepository.saveAndFlush(booking);
	    return true;
		}
	    else
		return false;
		
	}


	@Override
	public Booking getBookingDetailsById(int bookingId) 
	{
		
		return bookingRepository.findById(bookingId).get();
	}


	@Override
	public List<Booking> getBookingDetailsByDate(LocalDate date) 
	{
		
		
		
		return bookingRepository.getBookingDetailsByDate(date);

	}

	@Override
	public List<Booking> getAllBookingDetails() 
	{
		
			
		return bookingRepository.findAll();
	}


	@Override
	public void deleteBookingById(int id) 
	{
		
		
		bookingRepository.deleteById(id);

	}

}
