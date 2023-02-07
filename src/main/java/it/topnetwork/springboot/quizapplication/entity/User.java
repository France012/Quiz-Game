package it.topnetwork.springboot.quizapplication.entity;

import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.topnetwork.springboot.quizapplication.exception.ValidPassword;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="cognome")
	@NotNull
	private String cognome;
	
	@Column(name="username")
	@NotNull
	@Size(min = 4, message="Username troppo breve, dovrebbe essere di almeno 4 caratteri")
	private String username;
	
	@Column(name="password")
	@NotNull
	@ValidPassword
	private String password;
	
	@Column(name="data")
	private Date data;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="ass_ruolo_utente",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="ruolo_id")
			)
	private List <Ruolo> ruoli;
	
	@OneToMany(mappedBy = "risposta")
	private Set<StoricoRisposte> storicoRisposte = new HashSet<>();;

	public User() {
		
	}

	public User(String nome, String cognome, String username, String password, Date data) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuolo(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
	

	public Set<StoricoRisposte> getStoricoRisposte() {
		return storicoRisposte;
	}

	public void setStoricoRisposte(Set<StoricoRisposte> storicoRisposte) {
		this.storicoRisposte = storicoRisposte;
	}

		// add a conveince method for students
		public void addRuolo(Ruolo ruolo) {
			
			if (ruoli == null) {
				ruoli = new ArrayList<>();
			}
			
			ruoli.add(ruolo);
		}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", data=" + data + "]";
	}
	
	
}
