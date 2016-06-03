package com.needjob.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.needjob.JobSearch.HibernateUtil;
import com.needjob.model.Annonce;
import com.needjob.model.User;

public class AnnonceDaoImplementation implements AnnonceDao {

	@Override
	public void store(Annonce annonce) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
		try {
			tr= session.beginTransaction();
			session.save(annonce);			 
			tr.commit();
		}catch (HibernateException e) {
			tr.rollback();		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(Annonce annonce) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
			try {
				tr= session.beginTransaction();
				 session.delete(annonce);
				tr.commit();
			}catch (HibernateException e) {
				tr.rollback();
			}
			finally {
				session.close();
			}
	}

	@Override
	public List<Annonce> getAllAnnonces() {
		// TODO Auto-generated method stub
		List<Annonce> list=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
			try {
				tr= session.beginTransaction();
				 list=session.createQuery("from Annonce").list();
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
	public Annonce FindAnnonceById(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tr=null;
		Annonce annonce=null;
			try {
				tr= session.beginTransaction();
				 annonce=session.get(Annonce.class, id);
				tr.commit();
			}catch (HibernateException e) {
				tr.rollback();
			}
			finally {
				session.close();
			}
			return annonce;
	}

}
