package com.leonardo.banho_tosa.service;

import com.leonardo.banho_tosa.entity.Cliente;
import com.leonardo.banho_tosa.entity.Pet;
import com.leonardo.banho_tosa.repository.ClienteRepository;
import com.leonardo.banho_tosa.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    // apontando para o repository
    private final PetRepository petRepository;
    private final ClienteRepository clienteRepository;

    public PetService(PetRepository petRepository,
                      ClienteRepository clienteRepository) {
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    // metodo salvar com suas validacoes
    public Pet salvar(Pet pet) {

        // valicacao do nome
        if (pet.getNome() == null || pet.getNome().isBlank()) {
            throw new RuntimeException("Nome do pet é obrigatório");
        }

        //validacao para o pet ter um dono
        if (pet.getCliente() == null || pet.getCliente().getId() == null) {
            throw new RuntimeException("Cliente é obrigatório");
        }

        // busca no banco a valicacao
        Cliente cliente = clienteRepository.findById(pet.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        pet.setCliente(cliente);

        return petRepository.save(pet);
    }
}
