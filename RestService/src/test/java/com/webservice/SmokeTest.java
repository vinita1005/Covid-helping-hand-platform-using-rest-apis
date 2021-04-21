package com.webservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.webservice.controller.DonorController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	DonorController donorController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(donorController).isNotNull();
	}
	
}
