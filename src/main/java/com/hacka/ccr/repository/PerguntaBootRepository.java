package com.hacka.ccr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hacka.ccr.model.PerguntaBoot;

public interface PerguntaBootRepository extends CrudRepository<PerguntaBoot, Long>{

	 @Query("SELECT pb from PerguntaBoot pb where pb.tipo = :tipo ")
	 List<PerguntaBoot> obterPerguntaPorTipo(@Param("tipo") String tipo);
}