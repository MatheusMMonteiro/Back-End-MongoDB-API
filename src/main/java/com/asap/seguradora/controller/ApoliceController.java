package com.asap.seguradora.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asap.seguradora.documents.Apolice;
import com.asap.seguradora.repository.ApoliceRepository;
import com.asap.seguradora.service.ApoliceService;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoliceController {
	
	@Autowired
	private ApoliceService apoliceService;
	
	@Autowired
	private ApoliceRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Apolice>> buscarTodos(){
		List<Apolice> objetoLista = repository.findAll();
		
		if(objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	@GetMapping("/numero/{numero}")
	public ResponseEntity<Optional<Apolice>> buscarNumero(@PathVariable(value = "numero") long numero){
		Optional<Apolice> objetoLista = repository.findByNumero(numero);
		
		if(objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	@PostMapping
	public ResponseEntity<Apolice> cadastrarApolice(@RequestBody Apolice apolice){
		return apoliceService.cadastrarApolice(apolice)
				.map(resp -> ResponseEntity.status(201).body(apolice))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Apolice existente, cadastre outra apolice!");
				});
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Apolice> atualizarApolice(@Valid @RequestBody Apolice apolice){
		return apoliceService.atualizarApolice(apolice)
				.map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Apolice inexistente, passe uma apolice válida");
				});
	}
	
	@DeleteMapping("/deletar/{numero}")
	public ResponseEntity<Object> deletar (@PathVariable(value = "numero") long numero){
		return repository.findByNumero(numero).map(resp ->{
			repository.deleteByNumero(numero);
			return ResponseEntity.status(204).build();
		}).orElseThrow(() ->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"ID inexistente, passe um ID válido para deletar!");
		});
	}
	
	
	

}
