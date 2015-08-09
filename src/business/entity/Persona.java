package business.entity;

import integration.dao.helper.DateHelper;

import org.joda.time.LocalDate;



public abstract class Persona implements Entity {
	protected int id;
	protected String nome;
	protected String cognome;
	protected LocalDate dataNascita;
	protected String numTelefono;
	protected String eMail;

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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String toString() {
		return id + ", '" + nome + "', '" + cognome + "', '" + dataNascita + "', '" + numTelefono + "', '" + eMail + "'";
	}

}