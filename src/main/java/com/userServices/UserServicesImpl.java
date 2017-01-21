package com.userServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entities.Users;

@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	UserDao userDao;
	
	public List<Users> listUsers(){
		return userDao.listUsers();
	}
	public boolean delete(Users user){
		return userDao.delete(user);
	}
	public boolean saveOrUpdate(Users user){
		return userDao.saveOrUpdate(user);
	}

}
