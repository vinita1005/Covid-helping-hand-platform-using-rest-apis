package com.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.webservice.repo.DonorDao;
import com.webservice.vo.Donor;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(DonorDao repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", true,"A+")));
			log.info("Preloading " + repository.save(new Donor("Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+")));
		};
	}
}