package tn.esprit.khaddempro.DAO.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileEntity {
	public FileEntity(String name, String type, byte[] data) {
	
		this.name = name;
		this.type = type;
		this.data = data;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Lob
	private byte[] data;
	
}
