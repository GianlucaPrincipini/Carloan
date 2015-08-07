package business.entity;

public class Tariffario implements Entity {
	private double costoGiornaliero;
	private double costoSettimanale;
	private double moraChilometraggio;
	private double moraDurata;
	private double moraCarburante;
	private double costoChilometrico;
	private double assicurazioneBase;
	private double assicurazioneAvanzata;

	public double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public double getCostoSettimanale() {
		return costoSettimanale;
	}

	public void setCostoSettimanale(double costoSettimanale) {
		this.costoSettimanale = costoSettimanale;
	}

	public double getMoraChilometraggio() {
		return moraChilometraggio;
	}

	public void setMoraChilometraggio(double moraChilometraggio) {
		this.moraChilometraggio = moraChilometraggio;
	}

	public double getMoraDurata() {
		return moraDurata;
	}

	public void setMoraDurata(double moraDurata) {
		this.moraDurata = moraDurata;
	}

	public double getMoraCarburante() {
		return moraCarburante;
	}

	public void setMoraCarburante(double moraCarburante) {
		this.moraCarburante = moraCarburante;
	}

	public double getCostoChilometrico() {
		return costoChilometrico;
	}

	public void setCostoChilometrico(double costoChilometrico) {
		this.costoChilometrico = costoChilometrico;
	}

	public double getAssicurazioneBase() {
		return assicurazioneBase;
	}
	
	public void setAssicurazioneBase(double assicurazioneBase) {
		this.assicurazioneBase = assicurazioneBase;
	}

	public double getAssicurazioneAvanzata() {
		return assicurazioneAvanzata;
	}

	public void setAssicurazioneAvanzata(double assicurazioneAvanzata) {
		this.assicurazioneAvanzata = assicurazioneAvanzata;
	}
}