package com.bebela.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebela.demo.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
