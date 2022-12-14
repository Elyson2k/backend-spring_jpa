package com.springjpa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.project.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
