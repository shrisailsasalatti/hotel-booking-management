package com.virtusa.hotelreserve.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.virtusa.hotelreserve.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	@Query("SELECT u FROM User u WHERE u.userName=:userName")
	public User findByUserName(@Param("userName")String userName);

}
