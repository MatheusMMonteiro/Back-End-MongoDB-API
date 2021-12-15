package com.asap.seguradora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asap.seguradora.documents.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	public Optional<Cliente> findByCpf(String cpf);
	
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
}
