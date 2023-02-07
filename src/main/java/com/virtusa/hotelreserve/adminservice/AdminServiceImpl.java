package com.virtusa.hotelreserve.adminservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.adminrepository.AdminRepository;
import com.virtusa.hotelreserve.entity.Admin;



@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepo;
	@Override
	public void createAdmin(Admin admin)
	{
		adminRepo.save(admin);
	}
	
}
