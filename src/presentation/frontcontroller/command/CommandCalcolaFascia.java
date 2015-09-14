package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;
import business.exception.CarloanException;
import business.exception.FasciaIndexException;

public class CommandCalcolaFascia implements Command{


	@Override
	public Object execute(Object entity) throws CarloanException {
		try {
			new ApplicationServiceModello().calcolaFascia((Modello) entity);
		} catch (FasciaIndexException | InstantiationException
				| IllegalAccessException e) {
			throw new CarloanException(e.getMessage());
		}
		return ((Modello)entity).getFascia().getId();
	}
	
}
