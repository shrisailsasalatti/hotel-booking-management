package com.virtusa.hotelreserve.roomrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.hotelreserve.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer>
{

}
