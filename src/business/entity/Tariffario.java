package business.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings({ "serial", "unused" })
public class Tariffario implements Entity, Serializable {
	private double costoGiornaliero;
	private double costoSettimanale;
	private double moraChilometraggio;
	private double moraDurata;
	private double moraCarburante;
	private double costoChilometrico;
	private double assicurazioneBase;
	private double assicurazioneAvanzata;
	private static Tariffario tariffario;

	// Rimuovere amministratore da agenzia?
	
	static {
		if (tariffario == null) {
			tariffario = new Tariffario();

		}
	}
	
	private Tariffario() {
		File file = new File("./tariffario/");
		if (!file.canRead()) {
			file.mkdirs();
		}
		try {
			ObjectInputStream input = new ObjectInputStream(
					new FileInputStream("./tariffario/tariffario.dat"));
			tariffario = (Tariffario) input.readObject();
			input.close();
		} catch (IOException e) {
			try {
				ObjectOutputStream output = new ObjectOutputStream(
						new FileOutputStream("./tariffario/tariffario.dat"));
				output.writeObject(tariffario);
				System.out.println("Salvato");
				output.close();
			} catch (IOException e1) {
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Tariffario getInstance() {
		return tariffario;
	}

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
	
	public static void main(String [] args) throws ClassNotFoundException {
		Tariffario a = Tariffario.getInstance();
	}
	
}