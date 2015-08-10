package business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;

import business.entity.Agenzia;
import business.entity.Optional;

public class Contratto implements Entity {
	private int id;
	private Operatore operatore;
	private Cliente cliente;
	private Agenzia agenziaNoleggio;
	private Agenzia agenziaConsegna;
	private LocalDate dataStipula;
	private LocalDate dataInizioNoleggio;
	private LocalDate dataChiusura;
	private Vettura vettura;
	private boolean chilometraggioLimitato;
	private int chilometraggio;
	private Rifornimento rifornimento;
	private double acconto;
	private boolean chiuso;
	private List<Optional> optionals = new ArrayList<Optional>();
	private double costo;
	private boolean assicurazioneAvanzata;

	public void setVettura(Vettura vettura) {
		this.vettura = vettura;
	}
	
	public Vettura getVettura() {
		return vettura;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Operatore getOperatore() {
		return operatore;
	}

	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agenzia getAgenziaNoleggio() {
		return agenziaNoleggio;
	}

	public void setAgenziaNoleggio(Agenzia agenziaNoleggio) {
		this.agenziaNoleggio = agenziaNoleggio;
	}

	public Agenzia getAgenziaConsegna() {
		return agenziaConsegna;
	}

	public void setAgenziaConsegna(Agenzia agenziaConsegna) {
		this.agenziaConsegna = agenziaConsegna; 
	}

	public LocalDate getDataStipula() {
		return dataStipula;
	}

	public void setDataStipula(LocalDate dataStipula) {
		this.dataStipula = dataStipula;
	}

	public LocalDate getDataInizioNoleggio() {
		return dataInizioNoleggio;
	}
	
	public void setDataInizioNoleggio(LocalDate dataInizioNoleggio) {
		this.dataInizioNoleggio = dataInizioNoleggio;
	}
	
	public LocalDate getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(LocalDate dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public double getAcconto() {
		return acconto;
	}

	public void setAcconto(double acconto) {
		this.acconto = acconto;
	}

	public boolean isChiuso() {
		return chiuso;
	}

	public void setChiuso(boolean chiuso) {
		this.chiuso = chiuso;
	}

	public List<Optional> getOptionals() {
		return optionals;
	}

	public void setOptionals(List<Optional> optionals) {
		this.optionals = optionals;
	}

	public Rifornimento getRifornimento() {
		return rifornimento;
	}

	public void setRifornimento(Rifornimento rifornimento) {
		this.rifornimento = rifornimento;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public boolean isChilometraggioLimitato() {
		return chilometraggioLimitato;
	}

	public void setChilometraggioLimitato(boolean chilometraggioLimitato) {
		this.chilometraggioLimitato = chilometraggioLimitato;
	}

	public int getChilometraggio() {
		return chilometraggio;
	}
	
	public void setChilometraggio(int chilometraggio) {
		this.chilometraggio = chilometraggio;
	}

	public boolean isAssicurazioneAvanzata() {
		return assicurazioneAvanzata;
	}

	public void setAssicurazioneAvanzata(boolean assicurazioneAvanzata) {
		this.assicurazioneAvanzata = assicurazioneAvanzata;
	}
	
	public String toString(){
		return id + ", '" + operatore.getUsername() + "', '" + cliente.getCodicePatente() + "', '" + vettura.getTarga() + "', " + agenziaNoleggio.getId() + ", " 
				+ agenziaConsegna.getId() + ", '" 
				+ dataStipula + "', '" + dataInizioNoleggio + "', " + chilometraggioLimitato + 
				", " + chilometraggio + ", " + rifornimento.getIndex() + ", " + acconto + ", " + chiuso + ", " + costo + ", " + assicurazioneAvanzata;
	}
	
	public static void main(String[] args) {
	       // Instantiate a Date object
	       
	        
	       // display time and date using toString()
	       //System.out.println(date.toString());
	}
}