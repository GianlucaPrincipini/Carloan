package business.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import business.exception.IncidenceOutOfBoundException;


@SuppressWarnings("serial")
public class IncidenzaFascia implements Serializable {
	private double capacit‡Bagagliaio;
	private double numeroPosti;
	private double numeroPorte;
	private double potenzaSuPeso;
	private double emissioniCO2;
	private static IncidenzaFascia incidenzaFascia;
	
	private IncidenzaFascia(){}
	
	public static IncidenzaFascia getInstance() {
		if(incidenzaFascia == null)
			incidenzaFascia = new IncidenzaFascia();
		load();
		return incidenzaFascia;
	}
	
	private static void load() {
		File file = new File("./incidenza/");
		if(!file.canRead()) {
			file.mkdirs();
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("./incidenza/incidenza.dat"));
			incidenzaFascia = (IncidenzaFascia) in.readObject();
			in.close();
		} catch(IOException e){
			try{
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./incidenza/incidenza.dat"));
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
	
	public void setCapacit‡Bagagliaio(double x) throws IncidenceOutOfBoundException {
		capacit‡Bagagliaio = x;
	}
	
	public double getCapacit‡Bagagliaio() {
		return capacit‡Bagagliaio;
	}
	
	public void setNumeroPosti(double x) throws IncidenceOutOfBoundException {
		numeroPosti = x;
	}
	
	public double getNumeroPosti() {
		return numeroPosti;
	}
	
	public void setNumeroPorte(double x) throws IncidenceOutOfBoundException {
	numeroPorte = x;
	}
	
	public double getNumeroPorte() {
		return numeroPorte;
	}
	
	public void setPotenzaSuPeso(double x) throws IncidenceOutOfBoundException {
		potenzaSuPeso = x;
	}
	
	public double getPotenzaSuPeso() {
		return potenzaSuPeso;
	}
	
	public void setEmissioniCO2(double x) throws IncidenceOutOfBoundException {
		emissioniCO2 = x;
	}
	
	public double getEmissioniCO2(){
		return emissioniCO2;
	}
	
}
