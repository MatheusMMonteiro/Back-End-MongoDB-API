package com.asap.seguradora.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Cliente {

	@Id	
	private String id;
	
	@Field
	private String nome;
	
	@Field
	private String cpf;
	
	@Field
	private String cidade;
	
	@Field
	private String estado;
	
	public Cliente() {
		
	}	

	public Cliente(String nome, String cpf) {	
		this.nome = nome;
		this.cpf = cpf;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
