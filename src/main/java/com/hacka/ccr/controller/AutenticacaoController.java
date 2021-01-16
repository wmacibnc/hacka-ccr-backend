package com.hacka.ccr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hacka.ccr.dto.AutenticacaoDTO;
import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.service.PessoaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/autenticacao")
public class AutenticacaoController {

	@Autowired
	private PessoaService service;

	@RequestMapping(method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutenticacaoDTO> autenticar(@RequestBody AutenticacaoDTO autenticacaoDTO) throws CcrException {
		return new ResponseEntity<>(service.autenticar(autenticacaoDTO), HttpStatus.OK);
	}

}
