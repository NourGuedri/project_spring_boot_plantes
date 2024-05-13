package com.nour.plantes;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Role;
import com.nour.plantes.entities.User;
import com.nour.plantes.service.PlanteService;
import com.nour.plantes.service.UserService;

import jakarta.annotation.PostConstruct;
@SpringBootApplication
//pour tester implements CommandLineRunner 👇🏿👇🏿👇🏿
public class PlanteProjApplication implements CommandLineRunner{
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
	SpringApplication.run(PlanteProjApplication.class, args);
	}
	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"AGENT")); userService.addRole(new Role(null,"USER")); //ajouter
	 * les users userService.saveUser(new User(null,"admin","123",true,null));
	 * userService.saveUser(new User(null,"nour","123",true,null));
	 * userService.saveUser(new User(null,"user1","123",true,null)); //ajouter les
	 * rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("nour", "USER"); userService.addRoleToUser("nour",
	 * "AGENT"); userService.addRoleToUser("user1", "USER"); }
	 */
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Password Encoded BCRYPT de 123:******************** ");
//		 System.out.println(passwordEncoder.encode("123"));
//		 System.out.println("Password Encoded BCRYPT de hamdi:******************** ");
//		 System.out.println(passwordEncoder.encode("hamdi"));
	repositoryRestConfiguration.exposeIdsFor(Plante.class);
	}
//@Override
//public void run(String... args) throws Exception {
//    planteService.savePlante(new Plante("Tulipe", "Jaune", new Date()));
//    planteService.savePlante(new Plante("Orchidée", "Violet", new Date()));
//    planteService.savePlante(new Plante("Lys", "Blanc", new Date()));
//    planteService.savePlante(new Plante("Dahlia", "Rose", new Date()));
//    planteService.savePlante(new Plante("Iris", "Bleu", new Date()));
//    planteService.savePlante(new Plante("Pivoine", "Rouge", new Date()));
//    planteService.savePlante(new Plante("Bégonia", "Orange", new Date()));
//    planteService.savePlante(new Plante("Amaryllis", "Rouge", new Date()));
//    planteService.savePlante(new Plante("Azalée", "Rose", new Date()));
//}
}