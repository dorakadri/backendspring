package tn.esprit.khaddempro.DAO.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name="Etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="idEtudiant")
	private Integer idEtudiant;
	private String prenomE;
	private String nomE;
	
	@Enumerated(EnumType.STRING)
	private Option options ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datenaissance")
	private  Date date_naissance; 
	
	@OneToMany(mappedBy = "etudiant")
	@JsonIgnore
	private Set<Contrat> contrat; 

	@ManyToMany(cascade=CascadeType.PERSIST)
     private List<Equipe> equipe;
	
	@ManyToOne
	private Departement departement ; 
	
}