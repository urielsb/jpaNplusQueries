package com.uriel.demoweb.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class MainEntity {

	@Id
	private long id;
	private String primaryData;
	@OneToMany
	@JoinColumn(name = "main_entity_id")
	private Set<ComplementEntity> complementData;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPrimaryData() {
		return primaryData;
	}
	
	public void setPrimaryData(String primaryData) {
		this.primaryData = primaryData;
	}

	public Set<ComplementEntity> getComplementData() {
		return complementData;
	}

	public void setComplementData(Set<ComplementEntity> complementData) {
		this.complementData = complementData;
	}
	
}
