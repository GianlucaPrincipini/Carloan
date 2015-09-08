package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;
import presentation.frontcontroller.CarloanFrontController;

public class CommandLogin implements Command<Operatore>{

	@Override
	public Operatore execute(Operatore entity) {
		ApplicationServiceOperatore service;
		Operatore operatore = null;
		try {
			service = new ApplicationServiceOperatore();
			if (service.login(entity)) {
				operatore = service.read(entity.getUsername());
				CarloanFrontController.getInstance().setUserAuthenticated(operatore);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return operatore;
	}

}
