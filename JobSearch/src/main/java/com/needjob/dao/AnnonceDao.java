package com.needjob.dao;

import java.util.List;

import com.needjob.model.Annonce;

public interface AnnonceDao {
	
	public void store(Annonce annonce);
	public void delete (Annonce annonce);
	public  List<Annonce> getAllAnnonces();
	public Annonce FindAnnonceById(int id);

}
