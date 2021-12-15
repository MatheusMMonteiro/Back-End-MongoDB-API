package com.asap.seguradora.documents;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Cliente {

	@Id	
	private String id;
	
	@NotBlank(message = "O atributo nome não pode ser vazio!")	
	@Size(min = 5, message = "O atributo nome deve conter no mínimo 5 caracteres!")
	private String nome;
	
	
	@NotBlank(message = "O atributo CPF não pode ser vazio!")
	@CPF(message = "O atributo CPF deve ser válido!")
	@Indexed(unique = true)
	private String cpf;
	
	
	@NotBlank(message = "O atributo cidade não pode ser vazio!")
	@Size(min = 5, message = "O atributo cidade deve conter no mínimo 5 caracteres!")
	private String cidade;
	
	
	@NotBlank(message = "O atributo UF não pode ser vazio!")
	@Size(min = 2, message = "O atributo UF deve conter no mínimo 2 caracteres!")
	private String uf;
	
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ","
				+ " cpf=" + cpf + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

	
}
