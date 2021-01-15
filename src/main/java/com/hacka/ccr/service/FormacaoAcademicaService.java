package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.FormacaoAcademica;
import com.hacka.ccr.repository.FormacaoAcademicaRepository;

@Service
public class FormacaoAcademicaService {

	@Autowired
	private FormacaoAcademicaRepository repository;

	@Transactional
	public FormacaoAcademica salvar(FormacaoAcademica formacaoAcademica) throws CcrException {
		return repository.save(formacaoAcademica);
	}

	public FormacaoAcademica obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<FormacaoAcademica> consultar() throws CcrException {
		return (List<FormacaoAcademica>) repository.findAll();
	}

}
