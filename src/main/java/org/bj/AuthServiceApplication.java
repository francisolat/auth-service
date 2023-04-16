package org.bj;

import java.util.stream.Stream;

import org.bj.dao.administration.RoleRepository;
import org.bj.entities.administration.Role;
import org.bj.metier.administration.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Roles

		/*
		 * Stream.of("USER", "ADMIN").forEach(r -> { roleRepository.save(new Role(null,
		 * r)); });
		 */

		// Utilisateurs

		/*
		 * Stream.of("user1", "user2", "admin").forEach(item -> {
		 * accountService.enregistrerUtilisateur(item, item, item, item, item, item +
		 * "@gmail.com"); }); accountService.addRoleToUtilisateur("admin", "ADMIN");
		 */

	}

	@Bean
	BCryptPasswordEncoder getPassEncoder() {
		return new BCryptPasswordEncoder();
	}

}
