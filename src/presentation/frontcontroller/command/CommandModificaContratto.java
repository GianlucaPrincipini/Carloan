package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;

public class CommandModificaContratto implements Command<Contratto> {

	@Override
	public Contratto execute(Contratto entity) {
		try {
			new ApplicationServiceContratto().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
