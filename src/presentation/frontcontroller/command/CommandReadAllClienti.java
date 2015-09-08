package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;

public class CommandReadAllClienti implements Command<List<Cliente>>{

	@Override
	public List<Cliente> execute(List<Cliente> entity) {
		try {
			return new ApplicationServiceCliente().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
