package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOptional;
import business.entity.Optional;

public class CommandReadOptional implements Command {
	@Override
	public Optional execute(Object entity) {
		try {
			return new ApplicationServiceOptional().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
