package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOptional;
import business.entity.Optional;

public class CommandModificaOptional implements Command<Optional> {

	@Override
	public Optional execute(Optional entity) {
		try {
			new ApplicationServiceOptional().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
