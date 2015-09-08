package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceFascia;
import business.entity.Fascia;

public class CommandAggiungiFascia implements Command<Fascia>{

	@Override
	public Fascia execute(Fascia entity) {
		ApplicationServiceFascia service;
		try{
			service = new ApplicationServiceFascia();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
