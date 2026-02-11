package com.leonardo.banho_tosa.entity;

import jakarta.persistence.*;

// diz que é uma entidade
@Entity
//nome da tabela no banco
@Table(name = "pets")

public class Pet {

    // para gerar um novo id automatico para cada pet ao cadastrar
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String nome;
    private String raca;
    private String porte;

    // relacionamento com o cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //construtor vazio
    public Pet() {
    }

    // construtor com paramentros
    public Pet(String nome, String raca, String porte, Cliente cliente) {
        this.nome = nome;
        this.raca = raca;
        this.porte = porte;
        this.cliente = cliente;
    }

    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
