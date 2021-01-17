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

import com.hacka.ccr.dto.ResultadoVocacionalDTO;
import com.hacka.ccr.exception.CcrException;
import com.hacka.ccr.model.Pessoa;
import com.hacka.ccr.model.PessoaVocacional;
import com.hacka.ccr.service.PessoaService;

@CrossOrigin
@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Pessoa obter(@PathVariable(value = "numeroPessoa") Long numeroPessoa) throws CcrException {
		return service.obter(numeroPessoa);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Pessoa> consultar() throws CcrException {
		return service.consultar();
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) throws CcrException {
		return new ResponseEntity<>(service.salvar(pessoa), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@RequestParam(value = "numeroPessoa") Long numeroPessoa) throws CcrException {
		service.excluir(numeroPessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = { RequestMethod.POST }, value = "/salvar-resposta-vocacional", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> salvarRespostaVocacional(@RequestBody PessoaVocacional pessoaVocacional) throws CcrException {
		service.salvarRespostaVocacional(pessoaVocacional);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/resultado-teste-vocacional/{idPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoVocacionalDTO resultadoTesteVocacional(@PathVariable(value = "idPessoa") Long idPessoa) throws CcrException {
		return service.resultadoTesteVocacional(idPessoa);
	}
}
