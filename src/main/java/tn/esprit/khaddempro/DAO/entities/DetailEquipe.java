package tn.esprit.khaddempro.DAO.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

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
@Table( name = "DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Integer idDetailEquipe; 
    private int salle;
    private String thematique;
 @OneToOne(mappedBy = "equipedetail")
 @JsonIgnore
 private Equipe equipe ;
 
}
