package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;
import business.exception.FasciaIndexException;

public class CommandCalcolaFascia implements Command{


	@Override
	public Object execute(Object entity) {
		try {
			new ApplicationServiceModello().calcolaFascia((Modello) entity);
		} catch (FasciaIndexException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		return ((Modello)entity).getFascia().getId();
	}
	
}
