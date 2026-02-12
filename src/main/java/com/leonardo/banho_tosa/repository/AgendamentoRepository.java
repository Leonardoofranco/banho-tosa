package com.leonardo.banho_tosa.repository;

import com.leonardo.banho_tosa.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

// cria um repositorio para a entidade agendamento, e para exterder da jpa para receber os métodos.
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
