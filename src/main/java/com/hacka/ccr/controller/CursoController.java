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
import com.hacka.ccr.model.Curso;
import com.hacka.ccr.service.CursoService;

@CrossOrigin
@Controller
@RequestMapping(value = "/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Curso obter(@PathVariable(value = "numeroCurso") Long numeroCurso) throws CcrException {
		return service.obter(numeroCurso);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> salvar(@RequestBody Curso curso) throws CcrException {
		return new ResponseEntity<>(service.salvar(curso), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroCurso") Long numeroCurso) throws CcrException {
		service.excluir(numeroCurso);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
