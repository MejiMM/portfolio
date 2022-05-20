package com.portfolio.service;

import com.portfolio.model.Educacion;
import com.portfolio.repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseMaria
 */
@Service
public class EducacionService implements IEducacion{
    
     @Autowired
    private EducacionRepo edRepo;

    @Override
    public List<Educacion> mostrarEducacion() {
        return edRepo.findAll();
    }

    @Override
    public void agregarEducacion(Educacion ed) {
        edRepo.save(ed);
    }

    @Override
    public void editarEducacion(Educacion ed) {
        
        edRepo.save(ed);
    }

    @Override
    public void eliminarEducacion(Long id) {
        
        edRepo.deleteById(id);
    }

    @Override
    public Educacion educacionItem(String titulo) {
        
         Educacion item = edRepo.findByTitulo(titulo);
         
         return item;
    }
    
}
