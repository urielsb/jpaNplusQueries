package com.uriel.demoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uriel.demoweb.entities.MainEntity;

@Repository
public interface MainEntityRepository 
	extends JpaRepository<MainEntity, Long> {

}
