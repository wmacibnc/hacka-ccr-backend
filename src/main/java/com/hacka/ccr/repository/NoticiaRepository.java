package com.hacka.ccr.repository;

import org.springframework.data.repository.CrudRepository;

import com.hacka.ccr.model.Noticia;
import com.hacka.ccr.model.Pessoa;

public interface NoticiaRepository extends CrudRepository<Noticia, Long>{

}