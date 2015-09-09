package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;

public class CommandReadClienti implements Command {
	@Override
	public Cliente execute(Object entity) {
		try {
			return new ApplicationServiceCliente().read((String) entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
