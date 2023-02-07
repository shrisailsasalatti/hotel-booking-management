package com.virtusa.hotelreserve.hotelrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.hotelreserve.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer>
{
	
/* not supported DML operations of delete query
	@Query("DELETE FROM Hotel h WHERE h.hotelId =:hotelId")
	public	void deleteHotel(@Param("hotelId")int id);
*/	
	
	
	// this modified above custom query it worked fine
	@Modifying
	@Transactional
	@Query("DELETE FROM Hotel h WHERE h.hotelId =:hotelId")
	public	void deleteHotel(@Param("hotelId")int id);
	
	@Query("SELECT h FROM Hotel h WHERE h.hotelName=:hotelName")
	public List<Hotel> findByName(@Param("hotelName") String hotelName);
	
	@Query("SELECT h FROM Hotel h WHERE h.city=:city")
	public List<Hotel> findByCity(@Param("city") String city);

/*	not worked
  @Query("SELECT h FROM Hotel h WHERE h.hotelId=:valueOf")
	public Optional<Hotel> findAllById(Integer valueOf);
	*/

}
