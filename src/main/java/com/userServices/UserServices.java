package com.userServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.Users;

@Service
public interface UserServices {
	public List<Users> listUsers();
	public boolean delete(Users user);
	public boolean saveOrUpdate(Users user);

}
