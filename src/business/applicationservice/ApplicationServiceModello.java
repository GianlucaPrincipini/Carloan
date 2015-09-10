package business.applicationservice;

import integration.dao.DAOFactory;
import integration.dao.DAOFascia;
import java.util.List;
import business.checker.CheckerFactory;
import business.entity.Fascia;
import business.entity.IncidenzaFascia;
import business.entity.Modello;
import business.exception.FasciaIndexException;
import business.exception.IntegrityException;

public class ApplicationServiceModello extends ApplicationServiceEntity<Modello> {

	
	private IncidenzaFascia incidenza;
	
	@SuppressWarnings("unchecked")
	public ApplicationServiceModello() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Modello.class), CheckerFactory.buildChecker(Modello.class));
	}

	public Fascia calcolaFascia(Modello modello) throws FasciaIndexException {
		List<Fascia> fasce = new DAOFascia().readAll();
		double indiceFascia = calcolaIndiceFascia(modello);
		for (Fascia f:fasce) {
			if (indiceFascia < f.getMax() && indiceFascia > f.getMin()) {
				modello.setFascia(f);
				return f;
			}
		}
		if (modello.getFascia() == null) {
			throw new FasciaIndexException();
		}
		return modello.getFascia();
	}
	
	private double calcolaIndiceFascia(Modello modello) {
		incidenza = IncidenzaFascia.getInstance();
		return modello.getCapacit‡Bagagliaio() * incidenza.getCapacit‡Bagagliaio() +
				  incidenza.getEmissioniCO2() * modello.getEmissioniCO2() + 
				  incidenza.getNumeroPorte() * modello.getNumeroPorte() +
				  incidenza.getNumeroPosti() * modello.getNumeroPosti() + 
				  incidenza.getPotenzaSuPeso() * ((double) modello.getPotenza() / (double) modello.getPeso());
	}

	@Override
	public void create(Modello entity) {
		try {
			checker.check(entity);
			dao.create(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Modello entity) {
		try {
			checker.isModifiable(read(Integer.toString(entity.getId())));
			checker.check(entity);
			dao.update(entity);
		} catch (IntegrityException e) {
			e.showError();
		}
	}

	@Override
	public void delete(Modello entity) {
		try {
			checker.isModifiable(read(Integer.toString(entity.getId())));
			checker.check(entity); 
			dao.delete(Integer.toString(entity.getId()));	
		} catch (IntegrityException e) {
			e.showError();
		}
	}

	@Override
	public List<Modello> readAll() {
		return dao.readAll();
	}

	@Override
	public Modello read(String pk) {
		return dao.read(pk);
	}
}
