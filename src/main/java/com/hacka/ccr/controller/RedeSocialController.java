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
import com.hacka.ccr.model.RedeSocial;
import com.hacka.ccr.service.RedeSocialService;

@CrossOrigin
@Controller
@RequestMapping(value = "/rede-social")
public class RedeSocialController {

	@Autowired
	private RedeSocialService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroRedeSocial}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RedeSocial obter(@PathVariable(value = "numeroRedeSocial") Long numeroRedeSocial) throws CcrException {
		return service.obter(numeroRedeSocial);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RedeSocial> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RedeSocial> salvar(@RequestBody RedeSocial redeSocial) throws CcrException {
		return new ResponseEntity<>(service.salvar(redeSocial), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroRedeSocial") Long numeroRedeSocial) throws CcrException {
		service.excluir(numeroRedeSocial);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
