package com.hacka.ccr.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autenticacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;
	private LocalDateTime dataHoraInclusao;

	public Autenticacao() {
		super();
	}

	public Autenticacao(String token, LocalDateTime dataHoraInclusao) {
		super();
		this.token = token;
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
