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
import com.hacka.ccr.model.Interesse;
import com.hacka.ccr.service.InteresseService;

@CrossOrigin
@Controller
@RequestMapping(value = "/interesse")
public class InteresseController {

	@Autowired
	private InteresseService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroInteresse}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Interesse obter(@PathVariable(value = "numeroInteresse") Long numeroInteresse) throws CcrException {
		return service.obter(numeroInteresse);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Interesse> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Interesse> salvar(@RequestBody Interesse interesse) throws CcrException {
		return new ResponseEntity<>(service.salvar(interesse), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroInteresse") Long numeroInteresse) throws CcrException {
		service.excluir(numeroInteresse);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
