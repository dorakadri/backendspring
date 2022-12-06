package tn.esprit.khaddempro.DAO.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="Etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEtudiant")
	private int idEtudiant; // Clé primaire
	private String prenomE;
	private String nomE;
	@Temporal(TemporalType.DATE)
	private  Date date_naissance; 
	@Enumerated(EnumType.STRING) 
	private Option option ;
	@OneToMany(mappedBy = "etudiant")
	@JsonIgnore
	private Set<Contrat> contrat; 
	@ManyToOne
	private Departement departement ; 
    
	@ManyToMany(cascade=CascadeType.PERSIST)
     private List<Equipe> equipe;
	// @Enumerated(EnumType.STRING)
	//private Option op;
	// Constructeur et accesseurs (getters) et mutateurs (setters)
	
	

	public Integer getIdEtudiant() {
		return idEtudiant;
	}
	
	public String getPrenomE() {
		return prenomE;
	}
	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	

	
	public Date getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}


	public Option getOption() {
		return option;
	}


	public void setOption(Option option) {
		this.option = option;
	}


	public Set<Contrat> getContrat() {
		return contrat;
	}


	public void setContrat(Set<Contrat> contrat) {
		this.contrat = contrat;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public List<Equipe> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Equipe> equipe) {
		this.equipe = equipe;
	}
	
	
	
	public Etudiant( ) {
}

	public Etudiant(int idEtudiant, String prenomE, String nomE, Date date_naissance, Option option,
			Set<Contrat> contrat, Departement departement, List<Equipe> equipe) {
		this.idEtudiant = idEtudiant;
		this.prenomE = prenomE;
		this.nomE = nomE;
		this.date_naissance = date_naissance;
		this.option = option;
		this.contrat = contrat;
		this.departement = departement;
		this.equipe = equipe;
	 
	}


	



}
