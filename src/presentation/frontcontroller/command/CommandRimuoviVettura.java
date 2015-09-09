package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandRimuoviVettura implements Command<Vettura>{

	@Override
	public Vettura execute(Vettura entity) {
		try {
			new ApplicationServiceVettura().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
