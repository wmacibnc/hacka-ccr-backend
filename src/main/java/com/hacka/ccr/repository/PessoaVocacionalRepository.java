package com.hacka.ccr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.PessoaVocacional;

public interface PessoaVocacionalRepository extends CrudRepository<PessoaVocacional, Long>{

	 @Query("SELECT pv from PessoaVocacional pv where pv.id_pessoa = :idPessoa ")
	 List<PessoaVocacional> obterPessoaVocacionalPorIdPessoa(@Param("idPessoa") Long idPessoa);
	 
}