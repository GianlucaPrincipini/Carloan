package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;

public class CommandModificaOperatore implements Command<Operatore> {

	@Override
	public Operatore execute(Operatore entity) {
		try {
			new ApplicationServiceOperatore().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
