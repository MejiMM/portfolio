package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Role {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column (unique=true)
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" + "name=" + name + '}';
    }
    
    
}
