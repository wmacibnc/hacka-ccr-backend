package com.hacka.ccr.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.hacka.ccr.dto.IdiomaNivelDTO;
import com.hacka.ccr.dto.InteresseDTO;
import com.hacka.ccr.dto.RedeSocialLinkDTO;


@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String email;
	private String senha;
	private String foto;
	private LocalDate dataNascimento;

	private Boolean possuiFilhos;

	// Endereço
	private String uf; // SP
	private String localidade; // São Paulo
	private String bairro; // Sé
	private String complemento; // lado ímpar
	private String logradouro; // Praça da Sé
	private String cep; // 01001-000

	// Telefone
	private String ddTelefone;
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_nacionalidade")
	private Nacionalidade nacionalidade;

	@ManyToOne
	@JoinColumn(name = "id_estado_civil")
	private EstadoCivil estadoCivil;

	@ManyToOne
	@JoinColumn(name = "id_auto_declaracao")
	private AutoDeclaracao autoDeclaracao;

	@ManyToOne
	@JoinColumn(name = "id_formacao_academica")
	private FormacaoAcademica formacaoAcademica;

	@Transient
	private List<IdiomaNivelDTO> idiomas;
	
	@Transient
	private List<RedeSocialLinkDTO> redes;
	
	@Transient
	private List<InteresseDTO> interesses;
	
	public Pessoa() {
		super();
	}

	public Pessoa(Long id) {
		super();
		this.id = id;
	}

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getPossuiFilhos() {
		return possuiFilhos;
	}

	public void setPossuiFilhos(Boolean possuiFilhos) {
		this.possuiFilhos = possuiFilhos;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdTelefone() {
		return ddTelefone;
	}

	public void setDdTelefone(String ddTelefone) {
		this.ddTelefone = ddTelefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public AutoDeclaracao getAutoDeclaracao() {
		return autoDeclaracao;
	}

	public void setAutoDeclaracao(AutoDeclaracao autoDeclaracao) {
		this.autoDeclaracao = autoDeclaracao;
	}

	public FormacaoAcademica getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public List<IdiomaNivelDTO> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<IdiomaNivelDTO> idiomas) {
		this.idiomas = idiomas;
	}

	public List<RedeSocialLinkDTO> getRedes() {
		return redes;
	}

	public void setRedes(List<RedeSocialLinkDTO> redes) {
		this.redes = redes;
	}

	public List<InteresseDTO> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<InteresseDTO> interesses) {
		this.interesses = interesses;
	}

}
