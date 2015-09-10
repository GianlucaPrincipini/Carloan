package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceIncidenza;
import business.entity.IncidenzaFascia;

public class CommandModificaIncidenza implements Command<IncidenzaFascia> {

	@Override
	public IncidenzaFascia execute(IncidenzaFascia entity) {
		try{
			new ApplicationServiceIncidenza().update(entity);
		} catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}

}
