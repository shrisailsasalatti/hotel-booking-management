package com.virtusa.hotelreserve.admincontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.adminservice.AdminService;
import com.virtusa.hotelreserve.customercontroller.CustomerController;
import com.virtusa.hotelreserve.entity.Admin;
//import com.virtusa.hotelreserve.entity.Hotel;
//import com.virtusa.hotelreserve.hotelservice.HotelService;
import com.virtusa.hotelreserve.entity.Hotel;



@RestController
@RequestMapping("/admin")
public class AdminController {
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	//@Autowired
//	private HotelService hotelService;
	
	
    @PostMapping("/adminRegistration")
	public HttpStatus saveAdmin(@RequestBody Admin admin)
	{
    	logger.info("-------------Admin Added----------");
    	adminService.createAdmin(admin);
    	return HttpStatus.CREATED;
	}
	
/*		@PostMapping("/addHotels")
	public HttpStatus saveHotel(@RequestBody Hotel hotel)
	{
		logger.info("-------------Hotel Added----------");
    	hotelService.createHotel(hotel);
    	return HttpStatus.CREATED;
	}
	@GetMapping("/viewAllHotels")
	public Iterable<Hotel> hotelList()
	{
		return hotelService.getAllHotel();
	}
	@DeleteMapping("/deleteHotelById/{hotelId}")
	public ResponseEntity<Boolean> deleteHotelById(@PathVariable("hotelId") int id)
	{
			 hotelService.delete(id);
			 return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
	}
	@PutMapping("/updateHotelDetails/{hotelId}")
	public void updateHotelDetails(@PathVariable("hotelId") int id)
	{
		  hotelService.updateHotel(id);
    }
    	@GetMapping("/viewByHotelCity/{city}")
	public List<Hotel> viewByHotelCity(@PathVariable("city") String city)
	{
		return hotelService.listByCity(city);
	}
		@GetMapping("/viewByHotelName/{hotelName}")
	public List<Hotel> viewByHotelName(@PathVariable("hotelName") String hotelName)
	{
		return hotelService.listByName(hotelName);
	}
    */
}