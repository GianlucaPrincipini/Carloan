package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandReadVettura implements Command{
	@Override
	public Vettura execute(Object entity) {
		try {
			return new ApplicationServiceVettura().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
