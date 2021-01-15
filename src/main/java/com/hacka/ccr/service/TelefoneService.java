package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Telefone;
import com.hacka.ccr.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository repository;

	@Transactional
	public Telefone salvar(Telefone telefone) throws CcrException {
		return repository.save(telefone);
	}

	public Telefone obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Telefone> consultar() throws CcrException {
		return (List<Telefone>) repository.findAll();
	}

}
