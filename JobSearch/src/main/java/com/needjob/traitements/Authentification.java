package com.needjob.traitements;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.needjob.JobSearch.HibernateUtil;
import com.needjob.dao.*;
import com.needjob.model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentification {
	
	
	
	public User verif_authentification(String login, String password) throws NoSuchAlgorithmException
	{
		User user = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hash=sb.toString();
        
        
        
        
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		
		try
		{
			tr = session.beginTransaction();
			
			List<User> maliste =  session.createQuery("from User u where u.pseudo='"+login+"' and u.password='"+hash+"'").list();
			
			if (!maliste.isEmpty()) user=maliste.get(0);
			
		}
		catch (HibernateException e)
		{
		}
		finally
		{
			session.close();
		}
		
		
		return user;
	}

}
