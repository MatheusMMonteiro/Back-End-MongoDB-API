package com.asap.seguradora.documents;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Apolice {
	
	@Id
	private String id;
	
	@NotNull
	private long numero;
	
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date inicioVigencia;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date finalVigencia;
	
	@NotBlank(message = "O atributo placaVeiculo não pode ser vazio!")
	@Size(min = 5, message = "O atributo placaVeiculo deve conter no mínimo 5 caracteres!")
	private String placaVeiculo;
	
	@NotNull(message = "O atributo valor não pode ser nulo!")
	private Float valor;
	
	@DBRef
	private Cliente idCliente;
	
	public Apolice() {
		
	}
	

	public Apolice(
	String placaVeiculo) {
		super();
		this.placaVeiculo = placaVeiculo;
		
	}


	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFinalVigencia() {
		return finalVigencia;
	}

	public void setFinalVigencia(Date finalVigencia) {
		this.finalVigencia = finalVigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Apolice [numero=" + numero + ", inicioVigencia=" + inicioVigencia + ", finalVigencia=" + finalVigencia
				+ ", placaVeiculo=" + placaVeiculo + ", valor=" + valor + ", idCliente=" + idCliente + "]";
	}
	
	

}
