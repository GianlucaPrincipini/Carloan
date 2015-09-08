package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandModificaVettura implements Command<Vettura> {

	@Override
	public Vettura execute(Vettura entity) {
		try {
			new ApplicationServiceVettura().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
