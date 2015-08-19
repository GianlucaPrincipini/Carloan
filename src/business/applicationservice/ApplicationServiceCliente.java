package business.applicationservice;

import java.util.List;

import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Cliente;
import integration.dao.DAO;
import integration.dao.DAOFactory;

public class ApplicationServiceCliente extends ApplicationServiceEntity<Cliente> implements Gestione<Cliente>{
	@SuppressWarnings("unchecked")
	protected ApplicationServiceCliente() throws InstantiationException, IllegalAccessException {
		super((DAO<Cliente>) DAOFactory.buildDao(Cliente.class), (Checker<Cliente>) CheckerFactory.buildChecker(Cliente.class));
	}


	@Override
	public void create(Cliente entity) {
		if (checker.check(entity))
			dao.create(entity);
	}

	@Override
	public void update(Cliente entity) {
		if (checker.isModifiable(dao.read(entity.getCodicePatente())))
			if (checker.check(entity))
				dao.update(entity);
	}

	@Override
	public void delete(Cliente entity) {
		if (checker.isModifiable(entity))
			dao.delete(entity.getCodicePatente());
			
	}

	@Override
	public Cliente read(String pk) {
		return dao.read(pk);
	}

	@Override
	public List<Cliente> readAll() {
		return dao.readAll();
	}

}
