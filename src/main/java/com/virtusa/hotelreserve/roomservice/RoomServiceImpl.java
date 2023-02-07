package com.virtusa.hotelreserve.roomservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.entity.Room;
import com.virtusa.hotelreserve.roomrepository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService
{
	@Autowired
	private RoomRepository roomRepo;
	@Override
	public Iterable<Room> getAllRoom() {
		
		return roomRepo.findAll();
	}

	@Override
	public void createRoom(Room room) {
		roomRepo.saveAndFlush(room);
		
	}

	@Override
	public void delete(int id) {
		roomRepo.deleteById(id);
		
	}
	
}
