package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;

public class CommandRimuoviCliente implements Command<Cliente>{

	@Override
	public Cliente execute(Cliente entity) {
		try {
			new ApplicationServiceCliente().delete(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
