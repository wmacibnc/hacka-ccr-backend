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
import com.hacka.ccr.model.Telefone;
import com.hacka.ccr.service.TelefoneService;

@CrossOrigin
@Controller
@RequestMapping(value = "/telefone")
public class TelefoneController {

	@Autowired
	private TelefoneService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroTelefone}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Telefone obter(@PathVariable(value = "numeroTelefone") Long numeroTelefone) throws CcrException {
		return service.obter(numeroTelefone);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Telefone> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> salvar(@RequestBody Telefone telefone) throws CcrException {
		return new ResponseEntity<>(service.salvar(telefone), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroTelefone") Long numeroTelefone) throws CcrException {
		service.excluir(numeroTelefone);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
