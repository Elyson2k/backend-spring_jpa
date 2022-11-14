package com.springjpa.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.project.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{


	Optional<Cliente> findByEmail(String email);

}
