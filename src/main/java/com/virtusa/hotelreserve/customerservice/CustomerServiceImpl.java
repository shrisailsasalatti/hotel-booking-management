package com.virtusa.hotelreserve.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.customerrepository.CustomerRepository;
import com.virtusa.hotelreserve.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;

	

	@Override
	public void createCustomer(Customer customer)
	{
		customerRepo.save(customer);
	}



	@Override
	public Iterable<Customer> getAllcustomer() {
		return customerRepo.findAll() ;
	}
	
}	