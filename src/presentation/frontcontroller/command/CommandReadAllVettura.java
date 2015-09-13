package presentation.frontcontroller.command;

import java.util.List;

import presentation.frontcontroller.CarloanFrontController;
import business.applicationservice.ApplicationServiceVettura;
import business.entity.Vettura;

public class CommandReadAllVettura implements Command<List<Vettura>>{

	@Override
	public List<Vettura> execute(List<Vettura> entity) {
		try {
			if (CarloanFrontController.getInstance().isAdmin())
				return new ApplicationServiceVettura().readAll();
			else 
				return new ApplicationServiceVettura().filtra(CarloanFrontController.getInstance().getUserAuthenticated().getAgenzia());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
