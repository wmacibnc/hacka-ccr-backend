package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Genero;
import com.hacka.ccr.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;

	@Transactional
	public Genero salvar(Genero genero) throws CcrException {
		return repository.save(genero);
	}

	public Genero obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Genero> consultar() throws CcrException {
		return (List<Genero>) repository.findAll();
	}

}
