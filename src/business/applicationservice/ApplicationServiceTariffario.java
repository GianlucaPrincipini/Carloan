package business.applicationservice;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import business.entity.Tariffario;

public class ApplicationServiceTariffario implements ApplicationService {
	public void update(Tariffario tariffario) {

		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./tariffario/tariffario.dat"));
			output.writeObject(tariffario);
			output.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	
}
