package business.applicationservice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import business.entity.Tariffario;

public class ApplicationServiceTariffario implements ApplicationService {
	
	public void update(Tariffario tariffario) throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./tariffario/tariffario.dat"));
		output.writeObject(tariffario);
		output.close();
	}
	
}
