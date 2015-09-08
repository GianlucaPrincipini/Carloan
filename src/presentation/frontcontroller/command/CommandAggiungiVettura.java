package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandAggiungiVettura implements Command<Vettura>{

	@Override
	public Vettura execute(Vettura entity) {
		ApplicationServiceVettura service;
		try{
			service = new ApplicationServiceVettura();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
