package org.bj.web.administration;

import org.bj.config.securite.SignUpForm;
import org.bj.entities.administration.Utilisateur;
import org.bj.metier.administration.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public Utilisateur register (@RequestBody SignUpForm u) {
		return accountService.enregistrerUtilisateur(u.getNom(),u.getPrenom(),u.getUsername(),u.getPassword(),u.getConfirmePassword(),u.getEmail());
	}
}
