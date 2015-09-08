package presentation.frontcontroller.command;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;

public class CommandAggiungiCliente implements Command<Cliente>{

	@Override
	public Cliente execute(Cliente entity) {
		ApplicationServiceCliente service;
		try{
			service = new ApplicationServiceCliente();
			service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

}
