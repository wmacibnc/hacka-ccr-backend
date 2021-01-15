package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Vaga;
import com.hacka.ccr.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repository;

	@Transactional
	public Vaga salvar(Vaga vaga) throws CcrException {
		return repository.save(vaga);
	}

	public Vaga obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Vaga> consultar() throws CcrException {
		return (List<Vaga>) repository.findAll();
	}

}
