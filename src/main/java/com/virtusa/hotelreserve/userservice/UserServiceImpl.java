package com.virtusa.hotelreserve.userservice;


import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.entity.Login;
import com.virtusa.hotelreserve.entity.User;
import com.virtusa.hotelreserve.loginrepository.LoginRepository;
import com.virtusa.hotelreserve.userrepository.UserRepository;


@Service
public class UserServiceImpl implements UserService
{
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public void createUser(User user)
	{
		userRepo.save(user);
	}
	@Override
	public void userValidation(String userName, String password) {
		User user = userRepo.findByUserName(userName);

		if ((userName.equals(user.getUserName())) && password.equals(user.getPassword())) {
			logger.info("-------------Successfully login----------");
			Login login = new Login();
			login.setUserName(userName);
			login.setPassword(password);
			loginRepo.save(login);
		} else {
			logger.info("-----Invalid username or password OR try to signup into system----------");
		}
	}
}
