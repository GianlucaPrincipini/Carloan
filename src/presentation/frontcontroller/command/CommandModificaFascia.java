package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceFascia;
import business.entity.Fascia;

public class CommandModificaFascia implements Command<Fascia> {

	@Override
	public Fascia execute(Fascia entity) {
		try {
			new ApplicationServiceFascia().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
