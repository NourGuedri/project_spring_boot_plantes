package com.nour.plantes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.plantes.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long>
{
Role findByRole(String role);
}