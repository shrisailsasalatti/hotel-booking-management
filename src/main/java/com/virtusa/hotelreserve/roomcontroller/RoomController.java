package com.virtusa.hotelreserve.roomcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.entity.Room;
import com.virtusa.hotelreserve.roomservice.RoomService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rooms")
@Tag(name = "Room Controller",description = "Room Managed Portal")
public class RoomController
{
	Logger logger=LoggerFactory.getLogger(RoomController.class);
	@Autowired
	private RoomService roomService;
	@PostMapping("/addRooms")
	public HttpStatus saveHotel(@RequestBody Room room)
	{
		logger.info("-------------Room Added----------");
    	roomService.createRoom(room);
    	return HttpStatus.CREATED;
	}
	@GetMapping("/viewAllRooms")
	public Iterable<Room> roomList()
	{
		return roomService.getAllRoom();
	}
	@DeleteMapping("/deleteRoomById/{roomId}")
	public ResponseEntity<Boolean> deleteRoomById(@PathVariable("roomId") int id)
	{
			 roomService.delete(id);
			 return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
	}
}
