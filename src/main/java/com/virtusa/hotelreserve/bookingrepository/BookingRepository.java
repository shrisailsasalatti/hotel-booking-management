package com.virtusa.hotelreserve.bookingrepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.virtusa.hotelreserve.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>
{
	@Query("SELECT b FROM Booking b WHERE b.bookingDate LIKE :bookingDate")
	public List<Booking> getBookingDetailsByDate(@Param("bookingDate") @JsonFormat(pattern="yyyy-MM-dd") LocalDate date);

}
