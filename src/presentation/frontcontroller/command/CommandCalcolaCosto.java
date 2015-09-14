package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;
import business.exception.CarloanException;

public class CommandCalcolaCosto implements Command{

	@Override
	public Object execute(Object entity) throws CarloanException {
		try {
	
			return new ApplicationServiceContratto().calcolaCosto((Contratto) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CarloanException(e.getMessage());
		}
	}

}
