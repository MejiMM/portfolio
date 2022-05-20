package com.portfolio.service;

import com.portfolio.model.Educacion;
import java.util.List;

/**
 *
 * @author JoseMaria
 */
public interface IEducacion {
    
    public List<Educacion> mostrarEducacion();
    public void agregarEducacion(Educacion ed);
    public void editarEducacion(Educacion ed);
    public void eliminarEducacion(Long  id);
    public Educacion educacionItem(String titulo);
}
