package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;

public class CommandRimuoviContratti implements Command<Contratto>{

	@Override
	public Contratto execute(Contratto entity) {
		try {
			new ApplicationServiceContratto().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
