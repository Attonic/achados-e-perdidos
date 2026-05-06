package io.github.achadoseperdidos.repository;

import io.github.achadoseperdidos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNome(String nome);

    boolean existsByNome(String nome);

    boolean existsByEmail(String email);
    
}
