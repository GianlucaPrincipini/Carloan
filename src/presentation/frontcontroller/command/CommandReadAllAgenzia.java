package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceAgenzia;
import business.entity.Agenzia;

public class CommandReadAllAgenzia implements Command<List<Agenzia>>{

	@Override
	public List<Agenzia> execute(List<Agenzia> entity) {
		try {
			return new ApplicationServiceAgenzia().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
