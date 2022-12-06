package tn.esprit.khaddempro.DAO.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departement")
public class Departement implements Serializable{
	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    @Column(name="idDepart")
	    private Integer idDepart; 
	    private String nomDepart; 
	    private String adresse; 
	      
	     @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
	   
	     private Set<Etudiant> etudiants ; 
	     
	     @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
	     private Set<Enseignant> Enseignants ;
	     
		public Departement() {
		}

		public Departement(Integer idDepart, String nomDepart, String adresse, Set<Etudiant> etudiants) {
			super();
			this.idDepart = idDepart;
			this.nomDepart = nomDepart;
			this.adresse = adresse;
			this.etudiants = etudiants;
		}

		public Departement(Integer idDepart, String nomDepart, Set<Etudiant> etudiants) {
			super();
			this.idDepart = idDepart;
			this.nomDepart = nomDepart;
			this.etudiants = etudiants;
		}

		
		public Integer getIdDepart() {
			return idDepart;
		}

		public void setIdDepart(Integer idDepart) {
			this.idDepart = idDepart;
		}

		public String getNomDepart() {
			return nomDepart;
		}

		public void setNomDepart(String nomDepart) {
			this.nomDepart = nomDepart;
		}

		
		
		@Override
		public String toString() {
			return "Departement [idDepart=" + idDepart + ", nomDepart=" + nomDepart + ", adresse=" + adresse
					+ ", etudiants=" + etudiants + "]";
		}

		public String getAdresse() {
			return adresse;
		}
		
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
}
