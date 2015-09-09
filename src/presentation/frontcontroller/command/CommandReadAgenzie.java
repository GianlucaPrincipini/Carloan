package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceAgenzia;
import business.entity.Agenzia;

public class CommandReadAgenzie implements  Command{

	@Override
	public Agenzia execute(Object entity) {
		try {
			return new ApplicationServiceAgenzia().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
