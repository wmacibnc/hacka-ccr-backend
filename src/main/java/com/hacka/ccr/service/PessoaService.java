package com.hacka.ccr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.dto.IdiomaNivelDTO;
import com.hacka.ccr.dto.InteresseDTO;
import com.hacka.ccr.dto.RedeSocialLinkDTO;
import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Idioma;
import com.hacka.ccr.model.Interesse;
import com.hacka.ccr.model.Pessoa;
import com.hacka.ccr.model.PessoaIdioma;
import com.hacka.ccr.model.PessoaInteresse;
import com.hacka.ccr.model.PessoaRedeSocial;
import com.hacka.ccr.model.RedeSocial;
import com.hacka.ccr.repository.PessoaIdiomaRepository;
import com.hacka.ccr.repository.PessoaInteresseRepository;
import com.hacka.ccr.repository.PessoaRedeSocialRepository;
import com.hacka.ccr.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoaIdiomaRepository pessoaIdiomaRepository;
	
	@Autowired
	private PessoaRedeSocialRepository pessoaRedeSocialRepository;
	
	@Autowired
	private PessoaInteresseRepository pessoaInteresseRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) throws CcrException {
		List<IdiomaNivelDTO> idiomas = pessoa.getIdiomas();
		List<RedeSocialLinkDTO> redes = pessoa.getRedes();
		List<InteresseDTO> interesses = pessoa.getInteresses();
		pessoa = repository.save(pessoa);
		salvarDadosTransientes(pessoa, idiomas, redes, interesses);
		return pessoa;
	}

	private void salvarDadosTransientes(Pessoa pessoa, List<IdiomaNivelDTO> idiomas, List<RedeSocialLinkDTO> redes,
			List<InteresseDTO> interesses) {
		salvarIdioma(pessoa, idiomas);
		salvarRedeSocial(pessoa, redes);
		salvarInteresse(pessoa, interesses);
	}

	private void salvarIdioma(Pessoa pessoa, List<IdiomaNivelDTO> idiomas) {
		pessoaIdiomaRepository.obterIdiomasPessoa(pessoa.getId()).forEach(pessoaIdioma ->{
			pessoaIdiomaRepository.deleteById(pessoaIdioma.getId());
		});

		for(IdiomaNivelDTO idiomaNivel : idiomas) {
			PessoaIdioma pessoaIdioma = new PessoaIdioma();
			pessoaIdioma.setIdioma(new Idioma(idiomaNivel.getId()));
			pessoaIdioma.setPessoa(pessoa);
			pessoaIdioma.setNivel(idiomaNivel.getNivel());
			pessoaIdiomaRepository.save(pessoaIdioma);			
		}
		preencherDadosIdioma(pessoa);
	}
	
	private void salvarRedeSocial(Pessoa pessoa, List<RedeSocialLinkDTO> redes) {
		pessoaRedeSocialRepository.obterRedesSociaisPessoa(pessoa.getId()).forEach(pessoaRede ->{
			pessoaRedeSocialRepository.deleteById(pessoaRede.getId());
		});

		for(RedeSocialLinkDTO rede : redes) {
			PessoaRedeSocial pessoaRede = new PessoaRedeSocial();
			pessoaRede.setRedeSocial(new RedeSocial(rede.getId()));
			pessoaRede.setPessoa(pessoa);
			pessoaRede.setLink(rede.getLink());;
			pessoaRedeSocialRepository.save(pessoaRede);			
		}
		preencherDadosRedes(pessoa);
	}
	
	private void salvarInteresse(Pessoa pessoa, List<InteresseDTO> interesses) {
		pessoaInteresseRepository.obterInteressesPessoa(pessoa.getId()).forEach(pessoaInteresse ->{
			pessoaInteresseRepository.deleteById(pessoaInteresse.getId());
		});

		for(InteresseDTO interesse : interesses) {
			PessoaInteresse pessoaInteresse = new PessoaInteresse();
			pessoaInteresse.setInteresse(new Interesse(interesse.getId()));
			pessoaInteresse.setPessoa(pessoa);
			pessoaInteresseRepository.save(pessoaInteresse);			
		}
		preencherDadosInteresse(pessoa);
	}

	public Pessoa obter(Long numeroPessoa) throws CcrException {
		Pessoa pessoa = repository.findById(numeroPessoa).get();
		preencherDadosTransientes(pessoa);
		return pessoa;
	}

	private void preencherDadosTransientes(Pessoa pessoa) {
		preencherDadosIdioma(pessoa);
		preencherDadosRedes(pessoa);
		preencherDadosInteresse(pessoa);
	}

	private void preencherDadosIdioma(Pessoa pessoa) {
		List<IdiomaNivelDTO> idiomas = new ArrayList<IdiomaNivelDTO>();
		pessoaIdiomaRepository.obterIdiomasPessoa(pessoa.getId()).forEach(pessoaIdioma ->{
			IdiomaNivelDTO dto = new IdiomaNivelDTO();
			dto.setId(pessoaIdioma.getIdioma().getId());
			dto.setNivel(pessoaIdioma.getNivel());
			dto.setNome(pessoaIdioma.getIdioma().getNome());
			idiomas.add(dto);
		});
		pessoa.setIdiomas(idiomas);
	}
	
	private void preencherDadosRedes(Pessoa pessoa) {
		List<RedeSocialLinkDTO> redes = new ArrayList<RedeSocialLinkDTO>();
		pessoaRedeSocialRepository.obterRedesSociaisPessoa(pessoa.getId()).forEach(pessoaRede ->{
			RedeSocialLinkDTO dto = new RedeSocialLinkDTO();
			dto.setId(pessoaRede.getRedeSocial().getId());
			dto.setLink(pessoaRede.getLink());
			dto.setNome(pessoaRede.getRedeSocial().getNome());
			redes.add(dto);
		});
		pessoa.setRedes(redes);
	}

	
	private void preencherDadosInteresse(Pessoa pessoa) {
		List<InteresseDTO> interesses = new ArrayList<InteresseDTO>();
		pessoaInteresseRepository.obterInteressesPessoa(pessoa.getId()).forEach(pessoaInteresse ->{
			InteresseDTO dto = new InteresseDTO();
			dto.setId(pessoaInteresse.getInteresse().getId());
			dto.setNome(pessoaInteresse.getInteresse().getNome());
			interesses.add(dto);
		});
		pessoa.setInteresses(interesses);
	}


	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Pessoa> consultar() throws CcrException {
		List<Pessoa> pessoas = (List<Pessoa>) repository.findAll();
		pessoas.forEach(pessoa ->{
			preencherDadosTransientes(pessoa);
		});
		return pessoas;
	}

}
