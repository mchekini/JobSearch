package com.neddjob.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.needjob.JobSearch.HibernateUtil;
import com.needjob.model.Annonce;

public class AnnonceDAOImpl implements AnnonceDAO{

	@Override
	public void store(Annonce annonce) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
            session.save(annonce);
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
	public void delete(Annonce Annonce) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
            session.delete(Annonce);
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
	public List<Annonce> GetAllAnnonces() {
		List<Annonce> maliste = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
			maliste = session.createQuery("from Annonce").list();
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
	public Annonce GetAnnonceById(int id) {
		Annonce Annonce = null;
		List<Annonce> maliste = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;	
		try
		{
			tr = session.beginTransaction();
			Annonce = session.get(Annonce.class, id);
			tr.commit();	
		}catch(Exception e)
		{
		tr.rollback();	
		}finally
		{
			session.close();
		}
		return Annonce;
	}

}
