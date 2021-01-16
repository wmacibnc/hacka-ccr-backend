package com.hacka.ccr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

	 @Query("SELECT p from Pessoa p where p.email = :email and p.senha = :senha ")
	 Pessoa obterPessoaEmailSenha(@Param("email") String email, @Param("senha") String senha);
	 
	 @Query("SELECT p from Pessoa p where p.email = :email ")
	 Pessoa obterPessoaEmail(@Param("email") String email);
}