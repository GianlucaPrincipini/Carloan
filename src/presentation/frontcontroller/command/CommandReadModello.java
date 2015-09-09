package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;

public class CommandReadModello implements  Command{

	@Override
	public Modello execute(Object entity) {
		try {
			return new ApplicationServiceModello().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
