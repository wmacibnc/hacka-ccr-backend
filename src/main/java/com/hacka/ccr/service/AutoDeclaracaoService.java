package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.AutoDeclaracao;
import com.hacka.ccr.repository.AutoDeclaracaoRepository;

@Service
public class AutoDeclaracaoService {

	@Autowired
	private AutoDeclaracaoRepository repository;

	@Transactional
	public AutoDeclaracao salvar(AutoDeclaracao autoDeclaracao) throws CcrException {
		return repository.save(autoDeclaracao);
	}

	public AutoDeclaracao obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<AutoDeclaracao> consultar() throws CcrException {
		return (List<AutoDeclaracao>) repository.findAll();
	}

}
