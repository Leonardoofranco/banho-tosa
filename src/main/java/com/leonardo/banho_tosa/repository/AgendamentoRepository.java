package com.leonardo.banho_tosa.repository;

import com.leonardo.banho_tosa.entity.Agendamento;
import com.leonardo.banho_tosa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

// cria um repositorio para a entidade agendamento, e para exterder da jpa para receber os métodos.
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


    boolean existsByPetAndDataHora(Pet pet, LocalDateTime dataHora);
}
