package com.needjob.traitements;

import java.util.List;

import com.needjob.dao.*;
import com.needjob.model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentification {
	
	
	
	public boolean verif_authentification(String login, String password) throws NoSuchAlgorithmException
	{
		boolean correct = false;
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hash=sb.toString();
        
        
		List<User> maliste = new UserDaoImplementation().getAllUsers();
		
		for (User u:maliste)
		{
			if (u.getPseudo().equals(login))
			{
				if (u.getPassword().equals(hash)) correct = true;
			}
		}
		
		
		return correct;
	}

}
