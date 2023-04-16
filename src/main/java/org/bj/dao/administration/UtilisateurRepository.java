package org.bj.dao.administration;

import org.bj.entities.administration.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	public Utilisateur findByUsername(String username);
}
