package com.hacka.ccr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PessoaRedeSocial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String link;

	// Relacionamento com Pessoa
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	// Relacionamento com RedeSocial
	@ManyToOne
	@JoinColumn(name = "id_rede_social")
	private RedeSocial redeSocial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public RedeSocial getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}

}
