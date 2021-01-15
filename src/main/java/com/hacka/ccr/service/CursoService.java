package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Curso;
import com.hacka.ccr.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	@Transactional
	public Curso salvar(Curso curso) throws CcrException {
		return repository.save(curso);
	}

	public Curso obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Curso> consultar() throws CcrException {
		return (List<Curso>) repository.findAll();
	}

}
