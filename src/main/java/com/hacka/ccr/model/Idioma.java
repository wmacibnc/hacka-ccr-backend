package com.hacka.ccr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Idioma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;

	// Relacionamento com PessoaIdioma
	@OneToMany(mappedBy = "idioma", targetEntity = PessoaIdioma.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PessoaIdioma> pessoaIdioma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PessoaIdioma> getPessoaIdioma() {
		return pessoaIdioma;
	}

	public void setPessoaIdioma(List<PessoaIdioma> pessoaIdioma) {
		this.pessoaIdioma = pessoaIdioma;
	}

	

}
