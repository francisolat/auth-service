package org.bj.dao.administration;

import java.util.List;

import org.bj.entities.administration.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByNom(String nom);
	
	@RestResource(path="searchByMotCle")
	List<Role> findByNomContains(@Param("motCle") String motCle);

	List<Role> findByNomOrDescriptionContains(@Param("motCle") String motCle, @Param("motCle") String motle);
}
