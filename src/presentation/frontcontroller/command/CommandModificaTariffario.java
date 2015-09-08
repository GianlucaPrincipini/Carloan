package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceTariffario;
import business.entity.Tariffario;

public class CommandModificaTariffario implements Command<Tariffario> {

	@Override
	public Tariffario execute(Tariffario entity) {
		try {
			new ApplicationServiceTariffario().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
}
