package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOptional;
import business.entity.Optional;

public class CommandAggiungiOptional implements Command<Optional>{

	@Override
	public Optional execute(Optional entity) {
		ApplicationServiceOptional service;
		try{
			service = new ApplicationServiceOptional();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
