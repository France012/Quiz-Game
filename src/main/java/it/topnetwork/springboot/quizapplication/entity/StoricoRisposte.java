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
@Table(name="storico_risposte")
public class StoricoRisposte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	@ManyToOne
	@JoinColumn(name = "risposta_id")
	private Risposta risposta;

	public StoricoRisposte() {
	}
	
	
	public StoricoRisposte(User user, Risposta risposta) {
		this.user = user;
		this.risposta = risposta;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Risposta getRisposta() {
		return risposta;
	}

	public void setRisposta(Risposta risposta) {
		this.risposta = risposta;
	}


	@Override
	public String toString() {
		return "StoricoRisposte [id=" + id + ", user=" + user + ", risposta=" + risposta + "]";
	} 
	
	
	
}
