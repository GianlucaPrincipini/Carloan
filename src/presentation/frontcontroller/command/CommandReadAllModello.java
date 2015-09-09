package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;

public class CommandReadAllModello implements Command<List<Modello>>{

	@Override
	public List<Modello> execute(List<Modello> entity) {
		try {
			return new ApplicationServiceModello().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
