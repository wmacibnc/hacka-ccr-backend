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
import com.hacka.ccr.model.FormacaoAcademica;
import com.hacka.ccr.service.FormacaoAcademicaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/formacao-academica")
public class FormacaoAcademicaController {

	@Autowired
	private FormacaoAcademicaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroFormacaoAcademica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FormacaoAcademica obter(@PathVariable(value = "numeroFormacaoAcademica") Long numeroFormacaoAcademica) throws CcrException {
		return service.obter(numeroFormacaoAcademica);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FormacaoAcademica> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormacaoAcademica> salvar(@RequestBody FormacaoAcademica formacaoAcademica) throws CcrException {
		return new ResponseEntity<>(service.salvar(formacaoAcademica), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroFormacaoAcademica") Long numeroFormacaoAcademica) throws CcrException {
		service.excluir(numeroFormacaoAcademica);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
