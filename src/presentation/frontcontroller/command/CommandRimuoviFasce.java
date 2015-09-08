package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceFascia;
import business.entity.Fascia;

public class CommandRimuoviFasce implements Command<Fascia>{

	@Override
	public Fascia execute(Fascia entity) {
		try {
			new ApplicationServiceFascia().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
