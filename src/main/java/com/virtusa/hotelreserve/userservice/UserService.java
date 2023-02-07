package com.virtusa.hotelreserve.userservice;

import com.virtusa.hotelreserve.entity.User;

public interface UserService 
{
	public void createUser(User user);
	public void userValidation(String userName, String password);
}
