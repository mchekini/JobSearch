package com.needjob.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.needjob.JobSearch.HibernateUtil;
import com.needjob.model.User;

public class UserDaoImplementation implements UserDao{

	@Override
	public void store(User user) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
		try {
			tr= session.beginTransaction();
			session.save(user);			 
			tr.commit();
		}catch (HibernateException e) {
			tr.rollback();		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
	Session session=HibernateUtil.getSessionFactory().openSession();
	Transaction tr=null;
		try {
			tr= session.beginTransaction();
			 session.delete(user);
			tr.commit();
		}catch (HibernateException e) {
			tr.rollback();
		}
		finally {
			session.close();
		}
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
			try {
				tr= session.beginTransaction();
				 list=session.createQuery("from User").list();
				tr.commit();
			}catch (HibernateException e) {
				tr.rollback();
			}
			finally {
				session.close();
			}
	
		return list;
	}

	@Override
	public User FindUserById(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
		User user=null;
			try {
				tr= session.beginTransaction();
				 user=session.get(User.class, id);
				tr.commit();
			}catch (HibernateException e) {
				tr.rollback();
			}
			finally {
				session.close();
			}
			return user;
	}

	 
}
