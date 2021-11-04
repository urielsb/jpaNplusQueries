package com.uriel.demoweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uriel.demoweb.entities.MainEntity;

@Repository
public interface MainEntityRepository 
		extends JpaRepository<MainEntity, Long> {
	
	@Query("SELECT DISTINCT m FROM MainEntity m LEFT JOIN FETCH m.complementData")
	public List<MainEntity> findAllMainEntityAndComplement();
}
