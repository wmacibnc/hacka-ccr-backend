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
import com.hacka.ccr.model.PerguntaBoot;
import com.hacka.ccr.service.PerguntaBootService;

@CrossOrigin
@Controller
@RequestMapping(value = "/pergunta-boot")
public class PerguntaBootController {

	@Autowired
	private PerguntaBootService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroPerguntaBoot}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PerguntaBoot obter(@PathVariable(value = "numeroPerguntaBoot") Long numeroPerguntaBoot) throws CcrException {
		return service.obter(numeroPerguntaBoot);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PerguntaBoot> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PerguntaBoot> salvar(@RequestBody PerguntaBoot perguntaBoot) throws CcrException {
		return new ResponseEntity<>(service.salvar(perguntaBoot), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroPerguntaBoot") Long numeroPerguntaBoot) throws CcrException {
		service.excluir(numeroPerguntaBoot);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
