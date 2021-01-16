package com.hacka.ccr.dto;

public class AutenticacaoDTO {

	private String email;
	private String senha;

	private Boolean autenticado;
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}