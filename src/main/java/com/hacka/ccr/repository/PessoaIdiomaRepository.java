package com.hacka.ccr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.PessoaIdioma;

public interface PessoaIdiomaRepository extends CrudRepository<PessoaIdioma, Long>{

	 @Query("SELECT pi from PessoaIdioma pi where pi.pessoa.id = :id ")
	 List<PessoaIdioma> obterIdiomasPessoa(@Param("id") Long id);
}