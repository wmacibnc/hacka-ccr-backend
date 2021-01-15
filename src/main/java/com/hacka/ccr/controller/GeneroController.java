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
import com.hacka.ccr.model.Genero;
import com.hacka.ccr.service.GeneroService;

@CrossOrigin
@Controller
@RequestMapping(value = "/genero")
public class GeneroController {

	@Autowired
	private GeneroService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroGenero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Genero obter(@PathVariable(value = "numeroGenero") Long numeroGenero) throws CcrException {
		return service.obter(numeroGenero);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Genero> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genero> salvar(@RequestBody Genero genero) throws CcrException {
		return new ResponseEntity<>(service.salvar(genero), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroGenero") Long numeroGenero) throws CcrException {
		service.excluir(numeroGenero);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
