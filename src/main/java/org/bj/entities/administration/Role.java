package org.bj.entities.administration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(length = 60)
    private String nom;
    @Column(length=60)
    private String description;
    // @Temporal(TemporalType.DATE)
    private Date dateCreation=new Date();
}
