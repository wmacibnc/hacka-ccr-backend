package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Interesse;
import com.hacka.ccr.repository.InteresseRepository;

@Service
public class InteresseService {

	@Autowired
	private InteresseRepository repository;

	@Transactional
	public Interesse salvar(Interesse interesse) throws CcrException {
		return repository.save(interesse);
	}

	public Interesse obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Interesse> consultar() throws CcrException {
		return (List<Interesse>) repository.findAll();
	}

}
