package com.uriel.demoweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplementEntity {

	@Id
	private long id;
	private String secundaryData;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getSecundaryData() {
		return secundaryData;
	}
	
	public void setSecundaryData(String secundaryData) {
		this.secundaryData = secundaryData;
	}
}
