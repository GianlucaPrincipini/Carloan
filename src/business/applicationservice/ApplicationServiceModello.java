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
			throw new FasciaIndexException("L'indice:  "+ indiceFascia + " non Ë compreso negli intervalli delle fasce presenti. \n "
					+ "Si prega di configurare le fasce in maniera adeguata");
		}
		return modello.getFascia();
	}
	
	private double calcolaIndiceFascia(Modello modello) {
		incidenza = IncidenzaFascia.getInstance();
		double indice = modello.getCapacit‡Bagagliaio() * incidenza.getCapacit‡Bagagliaio() +
				  incidenza.getEmissioniCO2() * modello.getEmissioniCO2() + 
				  incidenza.getNumeroPorte() * modello.getNumeroPorte() +
				  incidenza.getNumeroPosti() * modello.getNumeroPosti() + 
				  incidenza.getPotenzaSuPeso() * ((double) modello.getPotenza() / (double) modello.getPeso());
		System.out.println(indice);
		return indice;
	}

	@Override
	public void create(Modello entity) throws IntegrityException {
		checker.check(entity);
		dao.create(entity);
	}

	@Override
	public void update(Modello entity) throws IntegrityException {
		checker.isModifiable(read(Integer.toString(entity.getId())));
		checker.check(entity);
		dao.update(entity);
	}

	@Override
	public void delete(Modello entity) throws IntegrityException {
		checker.isModifiable(read(Integer.toString(entity.getId())));
		checker.check(entity); 
		dao.delete(Integer.toString(entity.getId()));	
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
