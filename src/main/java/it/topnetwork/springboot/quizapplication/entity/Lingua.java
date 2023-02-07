package it.topnetwork.springboot.quizapplication.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lingua")
public class Lingua {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@OneToMany(mappedBy = "codice", cascade = CascadeType.ALL)
	private Set <CodiciLingua> CodiciLingua;

	public Lingua() {
		
	}

	public Lingua(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Set<CodiciLingua> getCodiciLingua() {
		return CodiciLingua;
	}

	public void setCodiciLingua(Set<CodiciLingua> codiciLingua) {
		CodiciLingua = codiciLingua;
	}

	@Override
	public String toString() {
		return "Lingua [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
	
}
