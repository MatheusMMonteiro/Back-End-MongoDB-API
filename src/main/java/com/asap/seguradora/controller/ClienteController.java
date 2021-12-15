package com.asap.seguradora.controller;

import java.util.List;

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

import com.asap.seguradora.documents.Cliente;
import com.asap.seguradora.repository.ClienteRepository;
import com.asap.seguradora.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos(){
		List<Cliente> objetoLista = repository.findAll();
		
		if(objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> buscarNome(@PathVariable(value = "nome")String nome){
		List<Cliente> objetoLista = repository.findAllByNomeContainingIgnoreCase(nome);
		
		if(objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente (@RequestBody Cliente cliente){
		return clienteService.cadastrarCliente(cliente)
				.map(resp -> ResponseEntity.status(201).body(cliente))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Cliente existente, cadastre outro cliente!");
				});
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> atualizarCliente(@Valid @RequestBody Cliente cliente){
		return clienteService.atualizarCliente(cliente)
				.map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Cliente inexistente, passe um id válido");
				});
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") String id){
		return repository.findById(id).map(resp ->{
			repository.deleteById(id);
			return ResponseEntity.status(200).build();
		}).orElseThrow(() ->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"ID inexistente, passe um ID válido para deletar!");
		});
	}

}
