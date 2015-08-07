package business.entity;

import java.util.List;
import business.entity.Agenzia;
import business.entity.Optional;

public class Contratto implements Entity {
	private int idContratto;
	private Operatore operatore;
	private Cliente cliente;
	private Agenzia agenziaNoleggio;
	private Agenzia agenziaConsegna;
	private String dataStipula;
	private String dataChiusura;
	private boolean chilometraggioLimitato;
	private int chilometraggio;
	private Rifornimento rifornimento;
	private float acconto;
	private boolean chiuso;
	private List<Optional> optionals;
	private float costo;
	private boolean assicurazioneAvanzata;

	public int getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(int idContratto) {
		this.idContratto = idContratto;
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

	public String getDataStipula() {
		return dataStipula;
	}

	public void setDataStipula(String dataStipula) {
		this.dataStipula = dataStipula;
	}

	public String getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(String dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public float getAcconto() {
		return acconto;
	}

	public void setAcconto(float acconto) {
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
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
		return idContratto + ", '" + operatore.getUsername() + "', '" + cliente.getCodicePatente() + "', " + agenziaNoleggio.getIdAgenzia() + ", " 
				+ agenziaConsegna.getIdAgenzia() + ", '" 
				+ dataStipula + "'" + "', '" + dataChiusura + "'" + "', " + chilometraggioLimitato + 
				", " + chilometraggio + ", " + rifornimento + ", " + acconto + ", " + chiuso + ", " + costo + ", " + assicurazioneAvanzata;
	}
}