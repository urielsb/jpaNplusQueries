package com.uriel.demoweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uriel.demoweb.entities.MainEntity;
import com.uriel.demoweb.repositories.MainEntityRepository;

@RestController(value = "/")
public class DemoController {

	private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	
	private MainEntityRepository mainEntityRepository;
	
	public DemoController(MainEntityRepository mainEntityRepository) {
		this.mainEntityRepository = mainEntityRepository;
	}
	
	@GetMapping("all")
	public List<MainEntity> findAllMainEntity() {
		log.trace("findAllMainEntity -->");
		List<MainEntity> result = mainEntityRepository
				.findAllMainEntityAndComplement();
		log.trace("--> findAllMainEntity");
		return result;
	}
	
}
