package com.asap.seguradora.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asap.seguradora.documents.Apolice;

@Repository
public interface ApoliceRepository extends MongoRepository<Apolice, Long> {
	
	public Optional<Apolice> findByNumero(long numero);
	
	public Optional<Apolice> findByPlacaVeiculo(String placa);
	
	

}
