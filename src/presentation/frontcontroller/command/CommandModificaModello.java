package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;

public class CommandModificaModello implements Command<Modello> {

	@Override
	public Modello execute(Modello entity) {
		try {
			new ApplicationServiceModello().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
