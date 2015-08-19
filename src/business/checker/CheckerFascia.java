package business.checker;

import java.util.List;
import integration.dao.DAOFascia;
import business.entity.Fascia;

public class CheckerFascia implements Checker<Fascia>{
	public boolean check(Fascia entity) {
		List<Fascia> fasce = new DAOFascia().readAll();
		for (Fascia f:fasce) {
			if (entity.getMin() >= f.getMin() && entity.getMin() <= f.getMax())
				return false;
			if (entity.getMax() <= f.getMax() && entity.getMin() <= f.getMin())
				return false;
			if (entity.getMin() >= f.getMin() && entity.getMax() <= f.getMax())
				return false;
		}
		return true;
	}

	@Override
	public boolean isModifiable(Fascia entity) {
		// Quando si modifica la fascia ricordati di ricalcolarla in tutti i modelli
		return true;
	}
}
