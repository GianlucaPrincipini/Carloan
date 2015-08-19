package business.applicationservice;

import integration.dao.DAOFascia;

import java.util.List;

import business.entity.Fascia;
import business.entity.Modello;

public class ApplicationServiceModello implements ApplicationService {

	public Fascia calcolaFascia(Modello modello) {
		List<Fascia> fasce = new DAOFascia().readAll();
		double indiceFascia = calcolaIndiceFascia(modello);
		for (Fascia f:fasce) {
			if (indiceFascia < f.getMax() && indiceFascia > f.getMin()) {
				modello.setFascia(f);
				return f;
			}
		}
		return null;
	}
	
	private double calcolaIndiceFascia(Modello modello) {
		return 0;
	}
}
