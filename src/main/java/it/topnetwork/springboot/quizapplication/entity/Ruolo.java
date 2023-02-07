package it.topnetwork.springboot.quizapplication.entity;

import java.util.List;

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
@Table(name="ruolo")
public class Ruolo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="codice_id")
	private List<Codice> codici;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(
			name="ass_ruolo_utente",
			joinColumns=@JoinColumn(name="ruolo_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	private List<User> users;


	public Ruolo() {
		
	}


	public Ruolo(List<Codice> codici) {
		this.codici = codici;
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


	public void setCodice(List<Codice> codici) {
		this.codici = codici;
	}

	

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", codice=" + codici + "]";
	}
	
	
}
