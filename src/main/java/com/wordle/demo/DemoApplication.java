package com.wordle.demo;

import com.wordle.demo.service.DataFillerService;
import com.wordle.demo.service.GameManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(DemoApplication.class, args);
//		DataFillerService dataFillerService = new DataFillerService();
//		dataFillerService.fillData();
	}

}
