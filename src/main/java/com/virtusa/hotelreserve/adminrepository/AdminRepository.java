package com.virtusa.hotelreserve.adminrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtusa.hotelreserve.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> 
{
	

}
