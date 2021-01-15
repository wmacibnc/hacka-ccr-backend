package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Nacionalidade;
import com.hacka.ccr.repository.NacionalidadeRepository;

@Service
public class NacionalidadeService {

	@Autowired
	private NacionalidadeRepository repository;

	@Transactional
	public Nacionalidade salvar(Nacionalidade nacionalidade) throws CcrException {
		return repository.save(nacionalidade);
	}

	public Nacionalidade obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Nacionalidade> consultar() throws CcrException {
		return (List<Nacionalidade>) repository.findAll();
	}

}
