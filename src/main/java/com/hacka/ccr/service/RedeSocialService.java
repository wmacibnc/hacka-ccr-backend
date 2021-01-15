package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.RedeSocial;
import com.hacka.ccr.repository.RedeSocialRepository;

@Service
public class RedeSocialService {

	@Autowired
	private RedeSocialRepository repository;

	@Transactional
	public RedeSocial salvar(RedeSocial redeSocial) throws CcrException {
		return repository.save(redeSocial);
	}

	public RedeSocial obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<RedeSocial> consultar() throws CcrException {
		return (List<RedeSocial>) repository.findAll();
	}

}
