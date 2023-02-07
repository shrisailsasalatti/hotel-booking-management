package com.virtusa.hotelreserve.loginrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.hotelreserve.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>
{

}
