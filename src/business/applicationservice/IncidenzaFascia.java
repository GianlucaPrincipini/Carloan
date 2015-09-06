package business.applicationservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import business.entity.TipoCarburante;
import business.exception.IncidenceOutOfBoundException;

public class IncidenzaFascia implements Serializable {
	private double capacitàBagagliaio;
	private double numeroPosti;
	private double numeroPorte;
	private double potenzaSuPeso;
	private double emissioniCO2;
	private static IncidenzaFascia incidenzaFascia;
	
	static {
		if(incidenzaFascia == null)
			incidenzaFascia = new IncidenzaFascia();
	}
	
	private IncidenzaFascia(){
		File file = new File("./incidenza/");
		if(!file.canRead()) {
			file.mkdirs();
		}
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("./incidenza/incidenza.dat"));
			incidenzaFascia = (IncidenzaFascia) in.readObject();
			in.close();
		} catch(IOException e){
			try{
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("./incidenza/incidenza.dat"));
				out.writeObject(incidenzaFascia);
				out.close();
			} catch(IOException ex){
				ex.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static IncidenzaFascia getInstance() {
		return incidenzaFascia;
	}
	
	public void setCapacitàBagagliaio(double x) throws IncidenceOutOfBoundException {
		if (x >= 1 && x <= 1.5)
			capacitàBagagliaio = x;
		else throw new IncidenceOutOfBoundException();
	}
	
	public double getCapacitàBagagliaio() {
		return capacitàBagagliaio;
	}
	
	public void setNumeroPosti(double x) throws IncidenceOutOfBoundException {
		if( x >= 1 && x <= 2)
			numeroPosti = x;
		else throw new IncidenceOutOfBoundException();
	}
	
	public double getNumeroPosti() {
		return numeroPosti;
	}
	
	public void setNumeroPorte(double x) throws IncidenceOutOfBoundException {
		if (x >= 1 && x <= 1.5)
		numeroPorte = x;
		else throw new IncidenceOutOfBoundException();
	}
	
	public double getNumeroPorte() {
		return numeroPorte;
	}
	
	public void setPotenzaSuPeso(double x) throws IncidenceOutOfBoundException {
		if (x >= 1 && x <= 5)
			potenzaSuPeso = x;
		else throw new IncidenceOutOfBoundException();
	}
	
	public double getPotenzaSuPeso() {
		return potenzaSuPeso;
	}
	
	public void setEmissioniCO2(double x) throws IncidenceOutOfBoundException {
		if (x > 0 && x <= 1)
			emissioniCO2 = x;
		else throw new IncidenceOutOfBoundException();
	}
	
	public double getEmissioniCO2(){
		return emissioniCO2;
	}
	
}
