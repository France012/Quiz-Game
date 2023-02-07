package it.topnetwork.springboot.quizapplication.entity;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="risposta")
public class Risposta {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="codice_id")
	private List<Codice> codici;
	
	@Column(name="is_correct")
	private boolean isCorrect;
	
	@Column(name="data")
	private Date data;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<StoricoRisposte> storicoRisposte = new HashSet<>();

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

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
	
	public Set<StoricoRisposte> getStoricoRisposte() {
		return storicoRisposte;
	}

	public void setStoricoRisposte(Set<StoricoRisposte> storicoRisposte) {
		this.storicoRisposte = storicoRisposte;
	}

	public Risposta(List<Codice> codici, boolean isCorrect, Date data) {
		this.codici = codici;
		this.isCorrect = isCorrect;
		this.data = data;
	}

	public Risposta() {
		
	}

	@Override
	public String toString() {
		return "Risposta [id=" + id + ", codici=" + codici + ", isCorrect=" + isCorrect + ", data=" + data + "]";
	}
	
	
	
}
