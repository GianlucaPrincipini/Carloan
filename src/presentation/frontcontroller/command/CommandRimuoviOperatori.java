package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;

public class CommandRimuoviOperatori implements Command<Operatore>{

	@Override
	public Operatore execute(Operatore entity) {
		try {
			new ApplicationServiceOperatore().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
