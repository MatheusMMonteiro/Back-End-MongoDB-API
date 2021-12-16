package com.asap.seguradora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asap.seguradora.documents.Apolice;
import com.asap.seguradora.repository.ApoliceRepository;

@Service
public class ApoliceService {
	
	@Autowired
	private ApoliceRepository repository;
	
	public Optional<Object> cadastrarApolice(Apolice apolice){
		return repository.findByPlacaVeiculo(apolice.getPlacaVeiculo()).map(resp ->{
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(apolice));
		});
	}
	
	public Optional<Apolice> atualizarApolice(Apolice apolice){
		return repository.findByNumero(apolice.getNumero()).map(resp ->{
			resp.setInicioVigencia(apolice.getInicioVigencia());
			resp.setFinalVigencia(apolice.getFinalVigencia());
			resp.setPlacaVeiculo(apolice.getPlacaVeiculo());
			resp.setValor(apolice.getValor());
			return Optional.ofNullable(repository.save(resp));
		}).orElseGet(() ->{
			return Optional.empty();
		});
		
	}
	
}
