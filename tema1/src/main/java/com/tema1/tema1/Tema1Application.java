package com.tema1.tema1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tema1Application {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Tema1Application.class, args);
		Simulator simulator = JsonFileProcessing.readJsonFileForModelingPN("modelPetri.json");
        simulator.executeSimulation();
	}
}
