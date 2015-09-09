package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandReadAllVettura implements Command<List<Vettura>>{

	@Override
	public List<Vettura> execute(List<Vettura> entity) {
		try {
			return new ApplicationServiceVettura().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
