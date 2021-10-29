package com.uriel.demoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uriel.demoweb.entities.ComplementEntity;

@Repository
public interface ComplementEntityRepository 
	extends JpaRepository<ComplementEntity, Long> {

}
