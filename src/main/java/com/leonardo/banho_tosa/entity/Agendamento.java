package com.leonardo.banho_tosa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //relacionamento com o Pet
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;


    @Column(nullable = false)
    private LocalDateTime dataHora;

    // serviço: banho ou banho e tosa.
    private String servico;

    public Agendamento() {
    }

    public Agendamento(Pet pet, LocalDateTime dataHora, String servico) {
        this.pet = pet;
        this.dataHora = dataHora;
        this.servico = servico;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
