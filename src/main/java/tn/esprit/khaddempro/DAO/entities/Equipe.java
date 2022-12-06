package tn.esprit.khaddempro.DAO.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

@Entity
@Table( name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Integer idEquipe; 
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niv;

@ManyToMany(mappedBy = "equipe")
@JsonIgnore
private List<Etudiant> etudiants ;

@OneToOne
private DetailEquipe equipedetail ;


@ManyToMany(mappedBy = "equipes")
@JsonIgnore
private List<Projet> projets ;



}
