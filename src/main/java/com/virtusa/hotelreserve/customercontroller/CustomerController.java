package com.virtusa.hotelreserve.customercontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.customerservice.CustomerService;
import com.virtusa.hotelreserve.entity.Customer;
import com.virtusa.hotelreserve.entity.Hotel;
// import com.virtusa.hotelreserve.entity.Hotel;
// import com.virtusa.hotelreserve.hotelservice.HotelService;
import com.virtusa.hotelreserve.hotelconroller.HotelController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
//	@Autowired
//	private HotelService hotelService;
	
	
    @PostMapping("/customerRegistration")
	public HttpStatus saveCustomer(@RequestBody Customer customer)
	{
    	logger.info("-------------Customer Added----------");
    	customerService.createCustomer(customer);
    	return HttpStatus.CREATED;
	}
    @GetMapping("/viewAllCustomers")
	public Iterable<Customer> hotelList()
	{
		return customerService.getAllcustomer();
	}

/*	@GetMapping("/searchByHotelName/{hotelName}")
	public List<Hotel> searchByHotelName(@PathVariable("hotelName") String hotelName)
	{
		return hotelService.listByName(hotelName);
	}
	@GetMapping("/searchByHotelCity/{city}")
	public List<Hotel> searchByHotelCity(@PathVariable("city") String city)
	{
		return hotelService.listByCity(city);
	}
*/	
}