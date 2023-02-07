package it.topnetwork.springboot.quizapplication.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="domanda")
public class Domanda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="codice_id")
	private List<Codice> codici;
	
	@Column(name="data")
	private Date data;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="domanda_id", referencedColumnName = "id")
	private List<Risposta> risposte;

	public Domanda() {
	}

	public Domanda(List<Codice> codici, Date data) {
		
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

	public List<Risposta> getRisposte() {
		return risposte;
	}

	public void setRisposte(List<Risposta> risposte) {
		this.risposte = risposte;
	}

	@Override
	public String toString() {
		return "Domanda [id=" + id + ", codici=" + codici + ", data=" + data + ", risposte=" + risposte + "]";
	}
	
	
	
	
	
	
	
}
