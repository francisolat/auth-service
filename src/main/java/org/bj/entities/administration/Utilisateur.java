package org.bj.entities.administration;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="utilisateur")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Utilisateur {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "prenom", nullable = false)
    private String prenom;
    
    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @JsonProperty(access=Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Boolean actived;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utilisateur_roles", 
      joinColumns = @JoinColumn(name = "utilisateur_id"), 
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new ArrayList<>();
    
    public Utilisateur(String nom, String prenom, String username, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
