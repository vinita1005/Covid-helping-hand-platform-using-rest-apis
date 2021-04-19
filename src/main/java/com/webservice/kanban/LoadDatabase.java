package com.webservice.kanban;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.webservice.kanban.repo.TaskDao;
import com.webservice.kanban.vo.Task;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(TaskDao repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Task(1001L, "Bilbo Baggins", 0)));
			log.info("Preloading " + repository.save(new Task(1002L, "Frodo Baggins", 1)));
		};
	}
}