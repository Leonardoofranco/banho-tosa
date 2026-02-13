package com.leonardo.banho_tosa.service;

import com.leonardo.banho_tosa.entity.Cliente;
import com.leonardo.banho_tosa.repository.ClienteRepository;
import org.springframework.stereotype.Service;

// anotação para dizer que faz parte de regra de negócio
@Service
public class ClienteService {

    // declaro qual repositório vai conversar
    private final ClienteRepository clienteRepository;

    // declaro que recebe pronto o repositorio do spring
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // metodo salvar, com suas validaçoes
    public Cliente salvar(Cliente cliente) {

        // valida o nome
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new RuntimeException("nome do cliente é obrigatório");
        }

        // valida o telefone
        if (cliente.getTelefone() == null || cliente.getTelefone().isBlank()) {
            throw new RuntimeException("Número de telefone é obrigatório");
        }

        return clienteRepository.save(cliente);

    }

}
