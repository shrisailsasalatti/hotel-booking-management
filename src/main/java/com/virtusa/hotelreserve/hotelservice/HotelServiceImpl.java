package com.virtusa.hotelreserve.hotelservice;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.entity.Hotel;
import com.virtusa.hotelreserve.entity.Room;
import com.virtusa.hotelreserve.hotelrepository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepository hotelRepo;
	
	@Override
	public List<Hotel> listByName(String hotelName) {
		
		return hotelRepo.findByName(hotelName);
	}
	@Override
	public List<Hotel> listByCity(String city) {
		
		return hotelRepo.findByCity(city);
	}

	@Override
	public Iterable<Hotel> getAllHotel()
	{
		return hotelRepo.findAll();
	}
	@Override
	public void createHotel(Hotel hotel)
	{
		hotelRepo.save(hotel);
	}
	@Override
	public void delete(int id) {
		hotelRepo.deleteById(id);
		//hotelRepo.deleteHotel(id);
	}
	@Override
	public void updateHotel(int id) {
	     Optional<Hotel> optional = hotelRepo.findById(id);
	     Hotel hotel = optional.get();
	     hotel.setDescription("Hotel for Family and Singles");
		 hotel.setPhone(884568622);
		 hotelRepo.save(hotel);
	}
	@Override
	public Iterable<Room> roomlistByHotel(){
	Hotel hotel = hotelRepo.findById(Integer.valueOf(1)).get();
	List<Room> rooms = hotel.getRooms();
	return rooms;
	}
}
	
