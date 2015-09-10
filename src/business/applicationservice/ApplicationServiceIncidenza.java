package business.applicationservice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import business.entity.IncidenzaFascia;

public class ApplicationServiceIncidenza {
	public void update(IncidenzaFascia incidenza) {

		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./incidenza/incidenza.dat"));
			output.writeObject(incidenza);
			output.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
}
