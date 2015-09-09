package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;

public class CommandReadOperatori implements Command{
	@Override
	public Operatore execute(Object entity) {
		try {
			return new ApplicationServiceOperatore().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
