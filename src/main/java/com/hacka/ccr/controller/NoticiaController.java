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
import com.hacka.ccr.model.Noticia;
import com.hacka.ccr.service.NoticiaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroNoticia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Noticia obter(@PathVariable(value = "numeroNoticia") Long numeroNoticia) throws CcrException {
		return service.obter(numeroNoticia);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Noticia> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Noticia> salvar(@RequestBody Noticia noticia) throws CcrException {
		return new ResponseEntity<>(service.salvar(noticia), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroNoticia") Long numeroNoticia) throws CcrException {
		service.excluir(numeroNoticia);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
