package com.virtusa.hotelreserve.paymentcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.customerrepository.CustomerRepository;
import com.virtusa.hotelreserve.entity.Customer;
import com.virtusa.hotelreserve.entity.MetaPayment;
import com.virtusa.hotelreserve.entity.Payment;
import com.virtusa.hotelreserve.paymentservice.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	CustomerRepository customerRepo;
	@PostMapping("/addMetaPaymentData")
	public HttpStatus addMetaPaymentData(@RequestBody MetaPayment metapayment)
	{
		
		Customer customer=customerRepo.findById(metapayment.getCustomerId()).get();
		metapayment.setCustomer(customer);
		paymentService.addMetaPayment(metapayment);
		return HttpStatus.CREATED;
		
	}

	@PostMapping("/paymentByCard")
	public HttpStatus addPaymentByCard(@RequestBody Payment payment)
	{
		
		paymentService.addPaymentByCard(payment);
		return HttpStatus.ACCEPTED;
		
	}
	
	@PostMapping("/paymentByUpi")
	public HttpStatus addPaymentByUpi(@RequestBody Payment payment)
	{
		
		paymentService.addPaymentByUpi(payment);
		return HttpStatus.ACCEPTED;
		
	}
	@DeleteMapping("/deletePaymentById/{id}")
	public HttpStatus removePaymentById(@PathVariable("id") int id)
	{
		
		paymentService.deletePaymentById(id);
		return HttpStatus.CREATED;
		
	}
}