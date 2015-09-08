package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceFascia;
import business.entity.Fascia;

public class CommandReadAllFasce implements Command<List<Fascia>>{

	@Override
	public List<Fascia> execute(List<Fascia> entity) {
		try {
			return new ApplicationServiceFascia().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
