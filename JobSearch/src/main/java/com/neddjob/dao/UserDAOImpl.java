package com.neddjob.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.needjob.JobSearch.HibernateUtil;
import com.needjob.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void store(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
            session.save(user);
			tr.commit();	
		}catch(Exception e)
		{
		tr.rollback();	
		}finally
		{
			session.close();
		}
		
	}

	@Override
	public void delete(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
            session.delete(user);
			tr.commit();	
		}catch(Exception e)
		{
		tr.rollback();	
		}finally
		{
			session.close();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> maliste = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
			maliste = session.createQuery("from User").list();
			tr.commit();	
		}catch(Exception e)
		{
		tr.rollback();	
		}finally
		{
			session.close();
		}
		
		
		return maliste;
	}

	@Override
	public User findUserByid(int id) {
		User user = null;
		List<User> maliste = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
			user = session.get(User.class, id);
			tr.commit();	
		}catch(Exception e)
		{
		tr.rollback();	
		}finally
		{
			session.close();
		}
		return user;
	}

}
