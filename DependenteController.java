package com.bebela.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bebela.demo.entities.Dependente;
import com.bebela.demo.services.DependenteService;

@RestController
@RequestMapping("/dependente")
public class DependenteController {
	
	private final DependenteService dependenteService;
	
	public DependenteController (DependenteService dependenteService) {
		this.dependenteService = dependenteService;
	}
	
	public ResponseEntity<Dependente> findDependenteoById(@PathVariable Long Id){
		Dependente dependente = dependenteService.getDependenteById(Id);
		
		if(dependente != null) {
			return ResponseEntity.ok(dependente);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Dependente>> findAllDependente(){
		List<Dependente>Dependente = dependenteService.getAllDependente();
		return ResponseEntity.ok(Dependente);
	}
	
	public ResponseEntity<Dependente> insertDependente(@RequestBody Dependente dependente){
		Dependente novoDependente = dependenteService.saveDependente(dependente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);
	}
}
