package com.needjob.model;

import java.sql.Date;

public class Annonce {
	
	private int id;
	private String titre;
	private String description;
	private Date date_publication;
	
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", titre=" + titre + ", description=" + description + ", date_publication="
				+ date_publication + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}

}
