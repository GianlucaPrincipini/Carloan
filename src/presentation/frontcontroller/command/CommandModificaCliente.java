package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;

public class CommandModificaCliente implements Command<Cliente>{

	@Override
	public Cliente execute(Cliente entity) {
		try {
			new ApplicationServiceCliente().update(entity);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

}
