package br.org.generation.meuprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.meuprojeto.model.estudos;
import br.org.generation.meuprojeto.repository.estudosRepository;

@RestController
@RequestMapping("/estudos")
@CrossOrigin("*")
public class estudosController {
	
	@Autowired
	private estudosRepository repository;
	
	public ResponseEntity<List<estudos>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

}
