package com.nour.plantes.service;

import com.nour.plantes.entities.Role;
import com.nour.plantes.entities.User;
public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
