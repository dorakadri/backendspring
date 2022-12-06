package tn.esprit.khaddempro.DAO.entities;



import java.io.Serializable;
import java.util.Date;
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

@Entity
@Table(name="Enseignant")
public class Enseignant implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idenseignant")
	private int idenseignant; // Clé primaire
	private String prenom;
	private String nom;
	@Temporal(TemporalType.DATE)
	private  Date dateembauche; 
	@Enumerated(EnumType.STRING) 
	private Fonction fonction ;
	
	@ManyToOne
	private Departement departement ;

	public Enseignant() {
		
	}

	public Enseignant(int idenseignant, String prenom, String nom, Date date_naissance, Fonction fonction,
			Departement departement) {
		this.idenseignant = idenseignant;
		this.prenom = prenom;
		this.nom = nom;
		this.dateembauche = dateembauche;
		this.fonction = fonction;
		this.departement = departement;
	}

	public int getIdenseignant() {
		return idenseignant;
	}

	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateembauche() {
		return dateembauche;
	}

	public void setDateembauche(Date dateembauche) {
		this.dateembauche = dateembauche;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Enseignant [idenseignant=" + idenseignant + ", prenom=" + prenom + ", nom=" + nom + ", date_naissance=" + dateembauche
				+ ", fonction=" + fonction + ", departement=" + departement + "]";
	} 
    
	
}
