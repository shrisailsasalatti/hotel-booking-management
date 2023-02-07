package com.virtusa.hotelreserve.roomservice;

import com.virtusa.hotelreserve.entity.Room;

public interface RoomService {
	public Iterable<Room> getAllRoom();
	public void createRoom(Room room);
	public void delete(int id);
}
