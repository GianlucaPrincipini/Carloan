package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceModello;
import business.entity.Modello;

public class CommandAggiungiModello implements Command<Modello>{

	@Override
	public Modello execute(Modello entity) {
		ApplicationServiceModello service;
		try{
			service = new ApplicationServiceModello();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
