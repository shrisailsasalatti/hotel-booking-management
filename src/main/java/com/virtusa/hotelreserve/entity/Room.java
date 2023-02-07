package com.virtusa.hotelreserve.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Room 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roomId;
	private int roomNum;
	@Enumerated(EnumType.STRING)
	@Column(name="roomType")
	private RoomType roomType; 
	private int perNightPrice;
	private Boolean avilability;
	private Blob photo;
	@ManyToOne
	private Hotel hotel;
	
	/*@Override
	 

	@JoinColumn(name="hotelId")//Optional
	@ManyToOne(targetEntity = Hotel.class)
	private Hotel hotel;
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room )) return false;
        return roomId != null && roomId.equals(((Room) o).getRoomId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	*/
	public Room()
	{
		super();
	}

	public Room(Integer roomId, int roomNum, RoomType roomType, int perNightPrice, Boolean avilability, Blob photo,
			Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.perNightPrice = perNightPrice;
		this.avilability = avilability;
		this.photo = photo;
		this.hotel = hotel;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getPerNightPrice() {
		return perNightPrice;
	}

	public void setPerNightPrice(int perNightPrice) {
		this.perNightPrice = perNightPrice;
	}

	public Boolean getAvilability() {
		return avilability;
	}

	public void setAvilability(Boolean avilability) {
		this.avilability = avilability;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNum=" + roomNum + ", roomType=" + roomType + ", perNightPrice="
				+ perNightPrice + ", avilability=" + avilability + ", photo=" + photo + ", hotel=" + hotel + "]";
	}
	
	

}
