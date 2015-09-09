package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceFascia;
import business.entity.Fascia;

public class CommandReadFascia implements Command {
	
	@Override
	public Fascia execute(Object entity) {
		try {
			return new ApplicationServiceFascia().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
