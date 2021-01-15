package com.hacka.ccr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.AutoDeclaracao;
import com.hacka.ccr.service.AutoDeclaracaoService;

@CrossOrigin
@Controller
@RequestMapping(value = "/auto-declaracao")
public class AutoDeclaracaoController {

	@Autowired
	private AutoDeclaracaoService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroAutoDeclaracao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AutoDeclaracao obter(@PathVariable(value = "numeroAutoDeclaracao") Long numeroAutoDeclaracao) throws CcrException {
		return service.obter(numeroAutoDeclaracao);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AutoDeclaracao> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutoDeclaracao> salvar(@RequestBody AutoDeclaracao autoDeclaracao) throws CcrException {
		return new ResponseEntity<>(service.salvar(autoDeclaracao), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroAutoDeclaracao") Long numeroAutoDeclaracao) throws CcrException {
		service.excluir(numeroAutoDeclaracao);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
