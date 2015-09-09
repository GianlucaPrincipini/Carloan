package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceAgenzia;
import business.entity.Agenzia;

public class CommandRimuoviAgenzia implements Command<Agenzia>{

	@Override
	public Agenzia execute(Agenzia entity) {
		try {
			new ApplicationServiceAgenzia().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
