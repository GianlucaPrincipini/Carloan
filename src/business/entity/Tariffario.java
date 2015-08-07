package business.entity;

public class Tariffario implements Entity {
	private float costoGiornaliero;
	private float costoSettimanale;
	private float moraChilometraggio;
	private float moraDurata;
	private float moraCarburante;
	private float costoChilometrico;
	private float assicurazioneBase;
	private float assicurazioneAvanzata;

	public float getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(float costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public float getCostoSettimanale() {
		return costoSettimanale;
	}

	public void setCostoSettimanale(float costoSettimanale) {
		this.costoSettimanale = costoSettimanale;
	}

	public float getMoraChilometraggio() {
		return moraChilometraggio;
	}

	public void setMoraChilometraggio(float moraChilometraggio) {
		this.moraChilometraggio = moraChilometraggio;
	}

	public float getMoraDurata() {
		return moraDurata;
	}

	public void setMoraDurata(float moraDurata) {
		this.moraDurata = moraDurata;
	}

	public float getMoraCarburante() {
		return moraCarburante;
	}

	public void setMoraCarburante(float moraCarburante) {
		this.moraCarburante = moraCarburante;
	}

	public float getCostoChilometrico() {
		return costoChilometrico;
	}

	public void setCostoChilometrico(float costoChilometrico) {
		this.costoChilometrico = costoChilometrico;
	}

	public float getAssicurazioneBase() {
		return assicurazioneBase;
	}
	
	public void setAssicurazioneBase(float assicurazioneBase) {
		this.assicurazioneBase = assicurazioneBase;
	}

	public float getAssicurazioneAvanzata() {
		return assicurazioneAvanzata;
	}

	public void setAssicurazioneAvanzata(float assicurazioneAvanzata) {
		this.assicurazioneAvanzata = assicurazioneAvanzata;
	}
}