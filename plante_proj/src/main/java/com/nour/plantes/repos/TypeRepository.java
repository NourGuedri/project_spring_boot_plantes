package com.nour.plantes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.plantes.entities.Type;


public interface TypeRepository extends JpaRepository<Type, Long> 
{
}
