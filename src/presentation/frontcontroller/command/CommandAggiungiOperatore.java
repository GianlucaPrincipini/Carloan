package presentation.frontcontroller.command;

import presentation.frontcontroller.CarloanFrontController;
import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;

public class CommandAggiungiOperatore implements Command<Operatore>{

	@Override
	public Operatore execute(Operatore entity) {
		ApplicationServiceOperatore service;
		if (CarloanFrontController.getInstance().isAdmin()) {
			try{
				service = new ApplicationServiceOperatore();
				service.create(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entity;
	}

}
