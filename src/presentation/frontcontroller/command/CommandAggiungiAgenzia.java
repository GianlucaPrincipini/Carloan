package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceAgenzia;
import business.entity.Agenzia;

public class CommandAggiungiAgenzia implements Command<Agenzia>{

	@Override
	public Agenzia execute(Agenzia entity) {
		ApplicationServiceAgenzia service;
		try{
			service = new ApplicationServiceAgenzia();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
