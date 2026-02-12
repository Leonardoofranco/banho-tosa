package com.leonardo.banho_tosa.repository;

import com.leonardo.banho_tosa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

// estou dizendo para o criar um repositorio para a entidade pet, para extender da jpa onde ja vem com os metodos por tras
public interface PetRepository extends JpaRepository<Pet, Long> {
}
