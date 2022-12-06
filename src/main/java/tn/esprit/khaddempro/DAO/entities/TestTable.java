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
@Table(name="TestTable")
public class TestTable implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private Integer idtest;
	private String prenomE;
	private String nomE;
	@Temporal(TemporalType.DATE)
	@Column(name="datenaissance")
	private  Date date_naissance; 

	
}