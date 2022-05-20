package com.portfolio.repository;

import com.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JoseMaria
 */
@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long>{
    
}
