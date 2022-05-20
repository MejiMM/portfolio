package com.portfolio.repository;

import com.portfolio.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepo extends JpaRepository<Role, Long>{
    
    public Optional<Role> findByName(String name);
}
