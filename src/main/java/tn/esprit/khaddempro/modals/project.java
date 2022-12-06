package tn.esprit.khaddempro.modals;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.khaddempro.DAO.entities.Etat;
import tn.esprit.khaddempro.DAO.entities.Niveau;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class project {
	 private Integer idProjet; 
	    private String nomProjet;
	    private String client ;
	    private String decription;
	    private Date deadline ;
	    private Etat etat;
	    private Niveau Field ;
	private List<String> equipes ;
//	private List<String> universite ;
}
