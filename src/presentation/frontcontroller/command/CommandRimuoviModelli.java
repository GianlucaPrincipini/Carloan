package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;

public class CommandRimuoviModelli implements Command<Modello>{

	@Override
	public Modello execute(Modello entity) {
		try {
			new ApplicationServiceModello().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
