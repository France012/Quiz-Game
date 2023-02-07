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
@Table(name="materia")
public class Materia {

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
	@JoinColumn(name="materia_id")
	private List<Argomento> argomenti;

	public Materia() {
		
	}

	public Materia(Date data) {
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

	public List<Argomento> getArgomenti() {
		return argomenti;
	}

	public void setArgomenti(List<Argomento> argomenti) {
		this.argomenti = argomenti;
	}
	
	public void addArgomento(Argomento theArgomento) {
		
		if (argomenti == null) {
			argomenti = new ArrayList<>();
		}
		
		argomenti.add(theArgomento);
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", codici=" + codici + ", data=" + data + "]";
	}
	
	
	
	
}
