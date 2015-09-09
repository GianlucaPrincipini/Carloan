package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;

public class CommandReadContratto implements Command{
	@Override
	public Contratto execute(Object entity) {
		try {
			return new ApplicationServiceContratto().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
