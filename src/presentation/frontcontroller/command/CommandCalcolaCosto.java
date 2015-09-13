package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;

public class CommandCalcolaCosto implements Command{

	@Override
	public Object execute(Object entity) {
		try {
			return new ApplicationServiceContratto().calcolaCosto((Contratto) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
