package com.hacka.ccr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String dd;
	private String numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
