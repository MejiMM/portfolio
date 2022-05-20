package com.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JoseMaria
 */
@Getter @Setter
@Entity
@Table (name = "educacion")
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String lugar;
    private String titulo;
    private String urlCert;
}
