package org.bj.config.securite;

import java.util.ArrayList;
import java.util.Collection;

import org.bj.entities.administration.Utilisateur;
import org.bj.metier.administration.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur u=accountService.findUserByUsername(username);
		if (u==null) throw new UsernameNotFoundException("Utilisateur invalide");
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		u.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getNom()));
		});
		return new User(u.getUsername(), u.getPassword(), authorities);
	}

}
