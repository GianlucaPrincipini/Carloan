package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;

public class CommandReadAllOperatore implements Command<List<Operatore>>{


	@Override
	public List<Operatore> execute(List<Operatore> entity) {
		try {
			return new ApplicationServiceOperatore().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
