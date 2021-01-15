package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.EstadoCivil;
import com.hacka.ccr.repository.EstadoCivilRepository;

@Service
public class EstadoCivilService {

	@Autowired
	private EstadoCivilRepository repository;

	@Transactional
	public EstadoCivil salvar(EstadoCivil estadoCivil) throws CcrException {
		return repository.save(estadoCivil);
	}

	public EstadoCivil obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<EstadoCivil> consultar() throws CcrException {
		return (List<EstadoCivil>) repository.findAll();
	}

}
