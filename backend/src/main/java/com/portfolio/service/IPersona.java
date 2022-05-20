/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.service;

import com.portfolio.model.Persona;
import java.util.List;

/**
 *
 * @author JoseMaria
 */
public interface IPersona  {
    
    public List<Persona> listaUsuarios();
    public void agregarUsuario(Persona usuario);
    public void editarUsuario(Persona usuario);
    public void eliminarUsuario(Long id);
    public Persona  buscarUsuario(Long id);
}
