package com.portfolio.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column (unique=true)    
    private String username;
    private String password;
    
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Role>  roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Long id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.password = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "roles=" + roles + '}';
    }
    
    
                
}
