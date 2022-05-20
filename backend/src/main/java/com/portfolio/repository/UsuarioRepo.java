package com.portfolio.repository;

import com.portfolio.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByUsername(String username);
    
    public Boolean existsByUsername(String username);
}
