package com.bebela.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebela.demo.entities.Funcionario;
import com.bebela.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario getFuncionarioById(Long Id) {
		return funcionarioRepository.findById(Id).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario savefuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
}
