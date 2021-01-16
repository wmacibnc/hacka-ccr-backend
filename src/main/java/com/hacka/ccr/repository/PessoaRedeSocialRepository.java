package com.hacka.ccr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.PessoaRedeSocial;

public interface PessoaRedeSocialRepository extends CrudRepository<PessoaRedeSocial, Long>{

	 @Query("SELECT prs from PessoaRedeSocial prs where prs.pessoa.id = :id ")
	 List<PessoaRedeSocial> obterRedesSociaisPessoa(@Param("id") Long id);
}