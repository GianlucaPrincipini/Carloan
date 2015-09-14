package business.applicationservice;

import java.util.Iterator;
import java.util.List;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Agenzia;
import business.entity.Vettura;
import business.exception.IntegrityException;

public class ApplicationServiceVettura extends ApplicationServiceEntity<Vettura> implements Gestione<Vettura>{

	@SuppressWarnings("unchecked")
	public ApplicationServiceVettura() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Vettura.class), CheckerFactory.buildChecker(Vettura.class));
	}

	@Override
	public void create(Vettura entity) throws IntegrityException {
		checker.check(entity);
		dao.create(entity);
	}

	@Override
	public void update(Vettura entity) throws IntegrityException {
		checker.isModifiable(read(entity.getTarga()));
		checker.check(entity);
		dao.update(entity);
	}

	@Override
	public void delete(Vettura entity) throws IntegrityException {
		checker.isModifiable(read(entity.getTarga()));
		checker.check(entity);
		dao.delete(entity.getTarga());
	}

	
	public List<Vettura> filtra(Agenzia agenzia) {
		List<Vettura> vetture = readAll();
		for (Iterator<Vettura> iv = vetture.iterator(); iv.hasNext();) {
			Vettura v = iv.next();
			if (v.getAgenziaLocalizzazione().getId() != agenzia.getId()) {
				iv.remove();
			}
		}
		return vetture;
	}
	
	@Override
	public List<Vettura> readAll() {
		return dao.readAll();
	}

	@Override
	public Vettura read(String pk) {
		return dao.read(pk);
	}

}
