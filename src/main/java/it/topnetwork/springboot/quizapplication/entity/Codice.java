package it.topnetwork.springboot.quizapplication.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="codice")
public class Codice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="data")
	private Date data;
	
	@OneToMany(mappedBy = "lingua")
	private Set <CodiciLingua> CodiciLingua;

	
	public Codice() {

	}


	public Codice(Date data) {
		super();
		this.data = data;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	
	public Set<CodiciLingua> getCodiciLingua() {
		return CodiciLingua;
	}


	public void setCodiciLingua(Set<CodiciLingua> codiciLingua) {
		CodiciLingua = codiciLingua;
	}


	@Override
	public String toString() {
		return "Codice [id=" + id + ", data=" + data + "]";
	}

	



	
	
	
}
