package com.virtusa.hotelreserve.hotelconroller;

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
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.entity.Hotel;
import com.virtusa.hotelreserve.entity.Room;
import com.virtusa.hotelreserve.hotelservice.HotelService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/hotel")
@Tag(name = "Hotel Controller",description = "Hotel Managed Portal")
public class HotelController {
	
	Logger logger=LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotels")
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
  /* 	@GetMapping("/viewAllRoomsByHotel")
	public Iterable<Room> viewAllRoomsByHotel()
	{
		return hotelService.roomlistByHotel();
	}
	*/
}
