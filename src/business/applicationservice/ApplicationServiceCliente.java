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
	public ApplicationServiceCliente() throws InstantiationException, IllegalAccessException {
		super((DAO<Cliente>) DAOFactory.buildDao(Cliente.class), (Checker<Cliente>) CheckerFactory.buildChecker(Cliente.class));
	}


	@Override
	public void create(Cliente entity) {
		try {
			checker.check(entity);
			dao.create(entity);
		} catch(CarloanException e) {
			e.showError();
		}
	}

	@Override
	public void update(Cliente entity) {
		try {
			checker.isModifiable(dao.read(entity.getCodicePatente()));
			checker.check(entity);
			System.out.println(entity);
			dao.update(entity);
		} catch (CarloanException e) {
			e.showError();
		}
	}

	@Override
	public void delete(Cliente entity) {
		try {
			checker.isModifiable(entity);
			dao.delete(entity.getCodicePatente());
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
