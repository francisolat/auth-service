package org.bj.metier.administration;

import org.bj.dao.administration.RoleRepository;
import org.bj.dao.administration.UtilisateurRepository;
import org.bj.entities.administration.Role;
import org.bj.entities.administration.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder ;
		 
	@Override
	public Utilisateur findUserByUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

	@Override
	public Utilisateur enregistrerUtilisateur(String nom,String prenom, String username, String password, String confirmePassword, String email) {
		Utilisateur u = findUserByUsername(username);
		if (u != null) throw new RuntimeException("Cet utilisateur existe déjà");
		if (!password.equals(confirmePassword))throw new RuntimeException("Confirmer voter mot de passe");
			Utilisateur user = new Utilisateur();
			user.setUsername(username);
			user.setPassword(bCryptPasswordEncoder.encode(password));
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setActived(true);
			utilisateurRepository.save(user);
			addRoleToUtilisateur(username, "USER");
		return user;
	}

	@Override
	public Role enregistrerRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUtilisateur(String username, String roleName) {
		Utilisateur u = findUserByUsername(username);
		Role role = roleRepository.findByNom(roleName);
		u.getRoles().add(role);
		utilisateurRepository.save(u);
	}

}
