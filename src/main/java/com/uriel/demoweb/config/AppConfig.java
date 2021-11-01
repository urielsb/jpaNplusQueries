package com.uriel.demoweb.config;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

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
			
			AtomicLong complementDataIdGenerator = new AtomicLong(1L);
			
			for(int i = 1; i <= 10; i++) {
				MainEntity mainEntity = new MainEntity();
				mainEntity.setId(i);
				mainEntity.setPrimaryData("Main Data " + i);
				mainEntity = mainEntityRepository.save(mainEntity);
				
				Set<ComplementEntity> complementData = buildComplementData(complementDataIdGenerator , 5);
				complementEntityRepository.saveAll(complementData);
				
				mainEntity.setComplementData(complementData);
				mainEntityRepository.save(mainEntity);
			}

		};
	}
	
	private Set<ComplementEntity> buildComplementData(AtomicLong index, int numberOfEntities) {
		Set<ComplementEntity> complementData = new HashSet<>();
		for(int i = 0; i < numberOfEntities; i++) {
			long complementDataId = index.getAndIncrement();
			ComplementEntity entity = new ComplementEntity();
			entity.setId(complementDataId);
			entity.setSecundaryData("Data " + complementDataId);
			
			complementData.add(entity);
		}
		
		return complementData;
	}
}
