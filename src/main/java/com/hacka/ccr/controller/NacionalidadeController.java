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
import com.hacka.ccr.model.Nacionalidade;
import com.hacka.ccr.service.NacionalidadeService;

@CrossOrigin
@Controller
@RequestMapping(value = "/nacionalidade")
public class NacionalidadeController {

	@Autowired
	private NacionalidadeService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroNacionalidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Nacionalidade obter(@PathVariable(value = "numeroNacionalidade") Long numeroNacionalidade) throws CcrException {
		return service.obter(numeroNacionalidade);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Nacionalidade> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nacionalidade> salvar(@RequestBody Nacionalidade nacionalidade) throws CcrException {
		return new ResponseEntity<>(service.salvar(nacionalidade), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroNacionalidade") Long numeroNacionalidade) throws CcrException {
		service.excluir(numeroNacionalidade);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
