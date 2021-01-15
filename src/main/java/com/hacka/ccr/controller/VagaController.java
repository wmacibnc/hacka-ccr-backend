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
import com.hacka.ccr.model.Vaga;
import com.hacka.ccr.service.VagaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/vaga")
public class VagaController {

	@Autowired
	private VagaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroVaga}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Vaga obter(@PathVariable(value = "numeroVaga") Long numeroVaga) throws CcrException {
		return service.obter(numeroVaga);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Vaga> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vaga> salvar(@RequestBody Vaga vaga) throws CcrException {
		return new ResponseEntity<>(service.salvar(vaga), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroVaga") Long numeroVaga) throws CcrException {
		service.excluir(numeroVaga);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
