package com.hacka.ccr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Noticia;
import com.hacka.ccr.repository.NoticiaRepository;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository repository;

	@Transactional
	public Noticia salvar(Noticia noticia) throws CcrException {
		return repository.save(noticia);
	}

	public Noticia obter(Long numeroProjeto) throws CcrException {
		return repository.findById(numeroProjeto).get();
	}

	public String excluir(Long numeroProjeto) throws CcrException {
		repository.deleteById(numeroProjeto);
		return "Excluído com sucesso!";
	}

	public List<Noticia> consultar() throws CcrException {
		return (List<Noticia>) repository.findAll();
	}

}
