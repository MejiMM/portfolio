package com.portfolio.repository;

import com.portfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JoseMaria
 */
@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Long>{
    
    public Educacion findByTitulo(String titulo);
}
