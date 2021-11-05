package com.uriel.demoweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uriel.demoweb.entities.MainEntity;

@Repository
public interface MainEntityRepository 
		extends JpaRepository<MainEntity, Long> {
	
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = "complementData")
	List<MainEntity> findAll();
}
