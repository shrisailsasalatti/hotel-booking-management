package com.virtusa.hotelreserve.paymentrepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.virtusa.hotelreserve.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>
{
	@Query("SELECT p FROM Payment p WHERE p.paymentDate LIKE :paymentDate")
	public List<Payment> getPaymentByDate(@Param("paymentDate") @JsonFormat(pattern="yyyy-MM-dd") LocalDate date);
}
