package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceAgenzia;
import business.entity.Agenzia;

public class CommandModificaAgenzie implements Command<Agenzia> {

	@Override
	public Agenzia execute(Agenzia entity) {
		try {
			new ApplicationServiceAgenzia().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
