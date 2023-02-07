package it.topnetwork.springboot.quizapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ass_codice_lingua")
public class CodiciLingua {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "lingua_id")
	private Lingua lingua; 

	@ManyToOne
	@JoinColumn(name = "codice_id")
	private Codice codice; 
	
	@Column(name="testo")
	private String testo;

	public CodiciLingua() {
	}

	public CodiciLingua(Lingua lingua, Codice codice, String testo) {
		this.lingua = lingua;
		this.codice = codice;
		this.testo = testo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	public Codice getCodice() {
		return codice;
	}

	public void setCodice(Codice codice) {
		this.codice = codice;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public String toString() {
		return "CodiciLingua [id=" + id + ", lingua=" + lingua + ", codice=" + codice + ", testo=" + testo + "]";
	} 
	
	
	
}
