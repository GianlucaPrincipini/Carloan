package business.applicationservice;

import java.util.List;

import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Cliente;
import business.exception.CarloanException;
import business.exception.IntegrityException;
import business.exception.UnmodifiableEntityException;
import integration.dao.DAO;
import integration.dao.DAOFactory;

public class ApplicationServiceCliente extends ApplicationServiceEntity<Cliente> {
	@SuppressWarnings("unchecked")
	protected ApplicationServiceCliente() throws InstantiationException, IllegalAccessException {
		super((DAO<Cliente>) DAOFactory.buildDao(Cliente.class), (Checker<Cliente>) CheckerFactory.buildChecker(Cliente.class));
	}


	@Override
	public void create(Cliente entity) {
		try {
			if (checker.check(entity))
				dao.create(entity);
			else throw new IntegrityException();
		} catch(CarloanException e) {
			e.showError();
		}
	}

	@Override
	public void update(Cliente entity) {
		try {
			if (checker.isModifiable(dao.read(entity.getCodicePatente())))
				if (checker.check(entity)) {
					dao.update(entity);
				} else throw new IntegrityException();
			else throw new UnmodifiableEntityException();
		} catch (CarloanException e) {
			e.showError();
		}
	}

	@Override
	public void delete(Cliente entity) {
		try {
			if (checker.isModifiable(entity))
				dao.delete(entity.getCodicePatente());
			else throw new UnmodifiableEntityException();
		} catch (CarloanException e) {
			e.showError();
		}
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
