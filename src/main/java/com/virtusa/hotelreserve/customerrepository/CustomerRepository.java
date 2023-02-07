package com.virtusa.hotelreserve.customerrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.hotelreserve.entity.Customer;
import com.virtusa.hotelreserve.entity.Hotel;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	
}
