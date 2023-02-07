package it.topnetwork.springboot.quizapplication.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="argomento")
public class Argomento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="codice_id")
	private List<Codice> codici;
	
	@Column(name="data")
	private Date data;
	
	@OneToMany(targetEntity=Domanda.class, fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="argomento_id")
	private List<Domanda> domande;

	public Argomento() {
	}

	public Argomento(List<Codice> codici, Date data) {
		this.codici = codici;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Codice> getCodici() {
		return codici;
	}

	public void setCodici(List<Codice> codici) {
		this.codici = codici;
	}
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
public void addDomande(Domanda domanda) {
		
		if (domande == null) {
			domande = new ArrayList<>();
		}
		
		domande.add(domanda);
	}
	


}
