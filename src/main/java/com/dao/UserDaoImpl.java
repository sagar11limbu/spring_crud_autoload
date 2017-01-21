package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Users;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Transaction trans;
	private Session session;
	
	public List<Users> listUsers(){
		session= sessionFactory.openSession();
		List<Users> list = session.createQuery("from Users").list();
		session.close();
		return list;
	}
	
	public boolean delete(Users user){
		session= sessionFactory.openSession();
		trans=session.beginTransaction();
		session.delete(user);
		trans.commit();
		session.close();
		return true;
		
	}
	
	public boolean saveOrUpdate(Users user){
		session= sessionFactory.openSession();
		trans=session.beginTransaction();
		session.saveOrUpdate(user);
		trans.commit();
		return true;
		
	}
	


}
