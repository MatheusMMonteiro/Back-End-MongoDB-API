package com.asap.seguradora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asap.seguradora.documents.Cliente;
import com.asap.seguradora.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Optional<Object> cadastrarCliente(Cliente cliente){		
			return repository.findByCpf(cliente.getCpf()).map(resp ->{
				return Optional.empty();
			}).orElseGet(() ->{
				return Optional.ofNullable(repository.save(cliente));
			});			
		
	}
	
	public Optional<Cliente> atualizarCliente(Cliente cliente){
		return repository.findById(cliente.getId()).map(resp ->{
			resp.setNome(cliente.getNome());
			resp.setCpf(cliente.getCpf());
			resp.setCidade(cliente.getCidade());
			resp.setUf(cliente.getUf());
			return Optional.ofNullable(repository.save(resp));
			
		}).orElseGet(() ->{
			return Optional.empty();
		});
	}
}
