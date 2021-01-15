package com.hacka.ccr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PessoaIdioma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer nivel;

	// Relacionamento com Pessoa
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	// Relacionamento com Idioma
	@ManyToOne
	@JoinColumn(name = "id_idioma")
	private Idioma idioma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

}
