package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.PerguntaBoot;
import com.hacka.ccr.repository.PerguntaBootRepository;

@Service
public class PerguntaBootService {

	@Autowired
	private PerguntaBootRepository repository;

	@Transactional
	public PerguntaBoot salvar(PerguntaBoot perguntaBoot) throws CcrException {
		return repository.save(perguntaBoot);
	}

	public List<PerguntaBoot> obterPorTipo(String tipo) throws CcrException {
		return repository.obterPerguntaPorTipo(tipo);
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<PerguntaBoot> consultar() throws CcrException {
		return (List<PerguntaBoot>) repository.findAll();
	}

}
