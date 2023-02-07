package com.virtusa.hotelreserve.hotelservice;

import java.util.List;

import com.virtusa.hotelreserve.entity.Hotel;
import com.virtusa.hotelreserve.entity.Room;

public interface HotelService {
	public List<Hotel> listByName(String hotelName);
	public List<Hotel> listByCity(String city);
	public Iterable<Hotel> getAllHotel();
	public void createHotel(Hotel hotel);
	public void delete(int id);
	public void updateHotel(int id);
	public Iterable<Room> roomlistByHotel();

}
