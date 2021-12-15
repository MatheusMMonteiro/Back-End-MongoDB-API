package com.asap.seguradora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asap.seguradora.documents.Cliente;
import com.asap.seguradora.repository.ClienteRepository;

@SpringBootApplication
public class SeguradoraVeiculosApplication implements CommandLineRunner {
	
	private  ClienteRepository clienteRepository;

	@Autowired
	public SeguradoraVeiculosApplication(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SeguradoraVeiculosApplication.class, args);
	}
	@Override
	public void run (String... args) throws Exception {
		
		if(clienteRepository.findAll().isEmpty()) {
			clienteRepository.save(new Cliente("Matheus", "12313221"));
			clienteRepository.save(new Cliente("Matheus monteiro", "1231a3221"));
		}
	}

}
