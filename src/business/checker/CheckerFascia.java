package business.checker;

import java.util.List;

import integration.dao.DAOFascia;
import business.entity.Fascia;
import business.exception.IntegrityException;

public class CheckerFascia implements Checker<Fascia>{
	public void check(Fascia entity) throws IntegrityException {
		List<Fascia> fasce = new DAOFascia().readAll();
		for (Fascia f:fasce) {
			if (entity.getId() != f.getId()) {
				if (entity.getMin() >= f.getMin() && entity.getMin() <= f.getMax())
					throw new IntegrityException();
				if (entity.getMax() <= f.getMax() && entity.getMin() <= f.getMin())
					throw new IntegrityException();
				if (entity.getMin() >= f.getMin() && entity.getMax() <= f.getMax())
					throw new IntegrityException();
			}
		}
	}

	@Override
	public void isModifiable(Fascia entity) {
		
	}
}
