package com.hacka.ccr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.Autenticacao;

public interface AutenticacaoRepository extends CrudRepository<Autenticacao, Long>{

	 @Query("SELECT a from Autenticacao a where a.token = :token ")
	 Autenticacao obterToken(@Param("token") String token);
}