package com.uriel.demoweb.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.uriel.demoweb.entities.ComplementEntity;
import com.uriel.demoweb.entities.MainEntity;
import com.uriel.demoweb.repositories.ComplementEntityRepository;
import com.uriel.demoweb.repositories.MainEntityRepository;

@Configuration
public class AppConfig {

	@Transactional
	@Bean
	public CommandLineRunner initData(
			MainEntityRepository mainEntityRepository, 
			ComplementEntityRepository complementEntityRepository) {
		return (args) -> {
			MainEntity mainEntityOne = new MainEntity();
			mainEntityOne.setId(1L);
			mainEntityOne.setPrimaryData("Main Data 1");
			mainEntityOne = mainEntityRepository.save(mainEntityOne);
			
			Set<ComplementEntity> complementData = new HashSet<>();
			for(int i = 1; i <= 10; i++) {
				ComplementEntity entityTwo = new ComplementEntity();
				entityTwo.setId(i);
				entityTwo.setSecundaryData("Data " + i);
				complementData.add(entityTwo);
			}
			
			complementEntityRepository.saveAll(complementData);
			
			mainEntityOne.setComplementData(complementData);
			mainEntityRepository.save(mainEntityOne);
			
			MainEntity mainEntityTwo = new MainEntity();
			mainEntityTwo.setId(2L);
			mainEntityTwo.setPrimaryData("Main Data 2");
			mainEntityTwo = mainEntityRepository.save(mainEntityTwo);
			
			Set<ComplementEntity> complementDataTwo = new HashSet<>();
			for(int i = 11; i <= 20; i++) {
				ComplementEntity entityTwo = new ComplementEntity();
				entityTwo.setId(i);
				entityTwo.setSecundaryData("Data " + i);
				complementDataTwo.add(entityTwo);
			}
			
			complementEntityRepository.saveAll(complementDataTwo);
			
			mainEntityTwo.setComplementData(complementDataTwo);
			mainEntityRepository.save(mainEntityTwo);
		};
	}
}
