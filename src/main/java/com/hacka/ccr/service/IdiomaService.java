package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Idioma;
import com.hacka.ccr.repository.IdiomaRepository;

@Service
public class IdiomaService {

	@Autowired
	private IdiomaRepository repository;

	@Transactional
	public Idioma salvar(Idioma idioma) throws CcrException {
		return repository.save(idioma);
	}

	public Idioma obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Idioma> consultar() throws CcrException {
		return (List<Idioma>) repository.findAll();
	}

}
