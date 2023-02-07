package com.virtusa.hotelreserve.customerservice;

import com.virtusa.hotelreserve.entity.Customer;

public interface CustomerService {
	
	public void createCustomer(Customer customer);
	public Iterable<Customer> getAllcustomer();
}