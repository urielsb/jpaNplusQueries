package com.uriel.demoweb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uriel.demoweb.entities.MainEntity;
import com.uriel.demoweb.repositories.ComplementEntityRepository;
import com.uriel.demoweb.repositories.MainEntityRepository;

@RestController(value = "/")
public class DemoController {

	private MainEntityRepository mainEntityRepository;
	private ComplementEntityRepository complementEntityRepository;
	
	public DemoController(MainEntityRepository mainEntityRepository,
			ComplementEntityRepository complementEntityRepository) {
		super();
		this.mainEntityRepository = mainEntityRepository;
		this.complementEntityRepository = complementEntityRepository;
	}
	
	@GetMapping("all")
	public List<MainEntity> findAllMainEntity() {
		return mainEntityRepository.findAll();
	}
	
}
