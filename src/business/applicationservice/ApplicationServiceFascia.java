package business.applicationservice;

import java.util.List;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Fascia;
import business.entity.Modello;
import business.exception.FasciaIndexException;
import business.exception.IntegrityException;

public class ApplicationServiceFascia extends ApplicationServiceEntity<Fascia> {

	public ApplicationServiceFascia() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Fascia.class), CheckerFactory.buildChecker(Fascia.class));
	}

	@Override
	public void create(Fascia entity) {
		try {
			checker.check(entity);
			dao.create(entity);
		} catch (IntegrityException e) {
			e.showError();
		}
	}

	@Override
	public void update(Fascia entity) {
		try {
			checker.isModifiable(dao.read(Integer.toString(entity.getId())));
			checker.check(entity);
			dao.update(entity);
			updateFasceModelli();
		}catch (IntegrityException e) {
			e.showError();
		}
		
	}

	private void updateFasceModelli() {
		ApplicationServiceModello asModello;
		try {
			asModello = new ApplicationServiceModello();
			List<Modello> modelli = asModello.readAll();
			for (Modello m:modelli) {
				try {
					asModello.calcolaFascia(m);
				} catch (FasciaIndexException e) {
					e.showError();
				}
				asModello.update(m);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void delete(Fascia entity) {
		try {
			checker.isModifiable(dao.read(Integer.toString(entity.getId())));
			List<Fascia> fasce = readAll();
			for (int i = 0; i < fasce.size(); i++) {
				if (fasce.get(i).getId() == 1) continue;
				if (fasce.get(i).compareTo(entity) == 0) {
					for (Fascia f:fasce) {
						if (f.getMax() == entity.getMin()) {
							f.setMax(entity.getMax());
							update(f);
							updateFasceModelli();
						}
					}
					dao.delete(Integer.toString(entity.getId()));
				}
			}
		} catch (IntegrityException e) {
			e.showError();
		}
	}

	@Override
	public List<Fascia> readAll() {
		return dao.readAll();
	}

	@Override
	public Fascia read(String pk) {
		return dao.read(pk);
	}
	
	
}
