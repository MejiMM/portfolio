package com.portfolio.service;

import com.portfolio.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.portfolio.repository.PersonaRepo;

/**
 *
 * @author JoseMaria
 */
@Service
public class PersonaService implements IPersona{
    
    @Autowired
    private PersonaRepo persRepo;

    @Override
    public List<Persona> listaUsuarios() {
        return persRepo.findAll();
    }

    @Override
    public void agregarUsuario(Persona usuario) {
        persRepo.save(usuario);
    }

    @Override
    public void editarUsuario(Persona usuario) {
        persRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
            persRepo.deleteById(id);
    }

    @Override
    public Persona buscarUsuario(Long id) {
       Persona user =  persRepo.findById(id).orElse(null);       
       
       return user;
    }
    
    
    
}
