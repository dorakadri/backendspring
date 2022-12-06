package tn.esprit.khaddempro.DAO.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table( name = "Contrat")
public class Contrat implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private Integer idContrat;
	@Temporal (TemporalType.DATE)
	private Date dateDebutContrat;
	@Temporal (TemporalType.DATE)
	private Date dateFinContrat;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	private Boolean archive;
	private Integer montantContrat;
	
	@ManyToOne(cascade =CascadeType.PERSIST )
    private Etudiant etudiant ;	
}