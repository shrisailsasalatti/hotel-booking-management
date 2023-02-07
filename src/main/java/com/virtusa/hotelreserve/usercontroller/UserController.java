package com.virtusa.hotelreserve.usercontroller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hotelreserve.entity.User;
import com.virtusa.hotelreserve.userservice.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/user")
@Tag(name = "User Controller",description = "User Managed Portal")
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
    @PostMapping("/userRegistration")
	public HttpStatus saveUser(@RequestBody User user)
	{
    	logger.info("-------------User Added----------");
    	userService.createUser(user);
    	return HttpStatus.CREATED;
	}
    @PostMapping("/userLogin/{userName}/{password}")
	public void userLogin(@PathVariable String userName, @PathVariable String password) {
		userService.userValidation(userName, password);

	}

}