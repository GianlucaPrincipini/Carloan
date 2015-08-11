package business.applicationservice;

import java.util.List;

import business.entity.Cliente;
import integration.dao.DAO;
import integration.dao.DAOFactory;

public class ApplicationServiceCliente extends ApplicationServiceEntity<Cliente>{
	@SuppressWarnings("unchecked")
	protected ApplicationServiceCliente() throws InstantiationException, IllegalAccessException {
		super((DAO<Cliente>) DAOFactory.buildDao(Cliente.class));
	}

	public List<Cliente> readAll() {
		return dao.readAll();
	}
}
