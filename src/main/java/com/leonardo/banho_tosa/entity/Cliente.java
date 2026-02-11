package com.leonardo.banho_tosa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity // para dizer que é uma entidade no banco
@Table(name = "clientes") // nome da tabela no banco
public class Cliente {


    @Id
    // gera um id automatico para cada cliente cadastrado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String nome;
    private String telefone;
    private String endereco;

    // relacionamento com o pet
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pet> pets;

    // contrutor vazio por causa do jpa
    public Cliente() {

    }

    //construtor com parametros
    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
