package com.neddjob.dao;
import java.util.List;

import com.needjob.model.*;

public interface AnnonceDAO {
	
	public void store(Annonce annonce);
	public void delete(Annonce annonce);
	public List<Annonce> GetAllAnnonces();
	public Annonce GetAnnonceById(int id);
	

}
