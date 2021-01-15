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
import com.hacka.ccr.model.Idioma;
import com.hacka.ccr.service.IdiomaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/idioma")
public class IdiomaController {

	@Autowired
	private IdiomaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroIdioma}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Idioma obter(@PathVariable(value = "numeroIdioma") Long numeroIdioma) throws CcrException {
		return service.obter(numeroIdioma);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Idioma> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Idioma> salvar(@RequestBody Idioma idioma) throws CcrException {
		return new ResponseEntity<>(service.salvar(idioma), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroIdioma") Long numeroIdioma) throws CcrException {
		service.excluir(numeroIdioma);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
