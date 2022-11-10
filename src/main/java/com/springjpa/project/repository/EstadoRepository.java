package com.springjpa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.project.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
