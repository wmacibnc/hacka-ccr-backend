package com.hacka.ccr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.PessoaInteresse;

public interface PessoaInteresseRepository extends CrudRepository<PessoaInteresse, Long>{

	 @Query("SELECT pi from PessoaInteresse pi where pi.pessoa.id = :id ")
	 List<PessoaInteresse> obterInteressesPessoa(@Param("id") Long id);
}