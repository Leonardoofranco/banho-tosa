package com.leonardo.banho_tosa.service;

import com.leonardo.banho_tosa.entity.Agendamento;
import com.leonardo.banho_tosa.entity.Pet;
import com.leonardo.banho_tosa.repository.AgendamentoRepository;
import com.leonardo.banho_tosa.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PetRepository petRepository;


    public AgendamentoService(AgendamentoRepository agendamentoRepository, PetRepository petRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.petRepository = petRepository;

    }

    // metodo agendar com suas regras de validacao
    public Agendamento agendar(Agendamento agendamento) {

        // validacao se o pet nao existir
        Pet pet = petRepository.findById(agendamento.getPet().getId())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        // validacao da data
        if (agendamento.getDataHora() == null) {
            throw new RuntimeException("Data do agendamento é obrigatória");
        }

        if (agendamento.getDataHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não é possível agendar para data passada");
        }

        // validacao para nao haver dois agendamento do mesmo pet no mesmo horario
        boolean existeAgendamento = agendamentoRepository
                .existsByPetAndDataHora(pet, agendamento.getDataHora());

        if (existeAgendamento) {
            throw new RuntimeException("Já existe agendamento para esse pet nesse horário");
        }

        agendamento.setPet(pet);

        return agendamentoRepository.save(agendamento);

    }

}