package com.virtusa.hotelreserve.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Hotel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hotelId;
	private String city;
	private String hotelName;
	private String address;
	private	String description;
	private	long phone;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private	List<Room> rooms=new ArrayList<>();
	/*
	 
	// For Sychronization Bidirectionally these two methods should be added
	  	
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy="hotel",targetEntity = Room.class,orphanRemoval = true)
	private	List<Room> rooms=new ArrayList<>();
	public void addRooms(Room room){
		   rooms.add(room);
		   room.setHotel(this);
		}

		public void removeRooms(Room room){
		   rooms.remove(room);
		   room.setHotel(null);
		}
        */
	
	public Hotel()
	{
		super();
	}

	public Hotel(Integer hotelId, String city, String hotelName, String address, String description, long phone,
			String email, List<Room> rooms) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.phone = phone;
		this.email = email;
		this.rooms = rooms;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", city=" + city + ", hotelName=" + hotelName + ", address=" + address
				+ ", description=" + description + ", phone=" + phone + ", email=" + email + ", rooms=" + rooms + "]";
	}
	
	
}	