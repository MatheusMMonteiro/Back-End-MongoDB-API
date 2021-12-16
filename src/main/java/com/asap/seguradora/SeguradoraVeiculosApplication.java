package com.asap.seguradora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asap.seguradora.documents.Apolice;
import com.asap.seguradora.documents.Cliente;
import com.asap.seguradora.repository.ApoliceRepository;
import com.asap.seguradora.repository.ClienteRepository;

@SpringBootApplication
public class SeguradoraVeiculosApplication implements CommandLineRunner {
	
	private  ClienteRepository clienteRepository;
	
	private ApoliceRepository apoliceRepository;

	@Autowired
	public SeguradoraVeiculosApplication(ApoliceRepository apoliceRepository, ClienteRepository clienteRepository) {
		this.apoliceRepository = apoliceRepository;
		this.clienteRepository = clienteRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SeguradoraVeiculosApplication.class, args);
	}
	@Override
	public void run (String... args) throws Exception {
		
		if(clienteRepository.findAll().isEmpty()) {
			clienteRepository.save(new Cliente("Matheus Monteiro de Almeida", "166.236.170-00"));	
		}
		if(apoliceRepository.findAll().isEmpty()) {
			apoliceRepository.save(new Apolice("ejk-2213"));
		}
	}

}
