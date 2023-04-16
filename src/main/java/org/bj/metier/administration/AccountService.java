package org.bj.metier.administration;

import org.bj.entities.administration.Role;
import org.bj.entities.administration.Utilisateur;

public interface AccountService {
	public Utilisateur findUserByUsername(String username);
	public Utilisateur enregistrerUtilisateur(String nom, String prenom,String username, String password, String confirmePassword,  String email);
	public Role enregistrerRole(Role role);
	public void addRoleToUtilisateur(String username, String roleName);
}
