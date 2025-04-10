package com.bebela.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bebela.demo.entities.Departamento;
import com.bebela.demo.services.DepartamentoService;

@RestController
@RequestMapping("/departametos")
public class DepartamentoController {
	
	private final DepartamentoService departamentoService;
	
	public DepartamentoController (DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	public ResponseEntity<Departamento> findDepartamentoById(@PathVariable Long Id){
		Departamento departamento = departamentoService.getDepartamentoById(Id);
		
		if(departamento != null) {
			return ResponseEntity.ok(departamento);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Departamento>> findAllDepartamentos(){
		List<Departamento>departamentos = departamentoService.getAllDepartamentos();
		return ResponseEntity.ok(departamentos);
	}
	
	public ResponseEntity<Departamento> insertDepartamento(@RequestBody Departamento departamento){
		Departamento novoDepartamento = departamentoService.saveDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}
}
