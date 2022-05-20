package com.portfolio.controller;

import com.portfolio.model.Educacion;
import com.portfolio.model.Persona;
import com.portfolio.service.EducacionService;
import com.portfolio.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JoseMaria
 */
@CrossOrigin
@RestController
public class Controller {
    
    @Autowired
    PersonaService uServ;
    
    @Autowired
    EducacionService edServ;
    
    @GetMapping("/usuarios")
    public List listaUsuarios() {
        return uServ.listaUsuarios();
    }
    
    @GetMapping("/educacion")
    public List mostrarEducacion() {
        return edServ.mostrarEducacion();
    }
      
    @PreAuthorize ("hasRole('admin')")
    @PostMapping("/usuario-nuevo")
    public void agregarUsuario(@RequestBody Persona persona) {
        uServ.agregarUsuario(persona);
    }
    
    @PreAuthorize ("hasRole('admin')")
    @PostMapping("/agregar-educacion")
    public Educacion agregarEducacion(@RequestBody Educacion ed) {
        edServ.agregarEducacion(ed);
        Educacion itemAgregado = edServ.educacionItem(ed.getTitulo());
        return itemAgregado;
    }
    
    @PreAuthorize ("hasRole('admin')")
    @DeleteMapping("/borrar-usuario/{id}")
    public void borrar(@PathVariable Long id) {
        uServ.eliminarUsuario(id);
    }
    
    @PreAuthorize ("hasRole('admin')")
    @DeleteMapping("/borrar-educacion/{id}")
    public List<Educacion> borrarEd(@PathVariable Long id) {
        edServ.eliminarEducacion(id);
        List<Educacion> elementosRestantes = edServ.mostrarEducacion();
        return elementosRestantes;
    }
    
    @PreAuthorize ("hasRole('admin')")
    @PutMapping ("editar/{id}")
    public void editar(@PathVariable Long id, @RequestBody Persona usuario) {
        
        Persona user = uServ.buscarUsuario(id);
        
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setDescripcion(usuario.getDescripcion());
        
        uServ.agregarUsuario(user);
    }
    
    
    
}
