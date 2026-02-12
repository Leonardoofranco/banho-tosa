package com.leonardo.banho_tosa.repository;

import com.leonardo.banho_tosa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// cria um repositorio automatico para a entidade Cliente. por causa do JPA cria temos alguns metodos automatico.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
