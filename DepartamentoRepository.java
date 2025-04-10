package com.bebela.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebela.demo.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
