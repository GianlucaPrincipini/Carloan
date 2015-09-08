package business.checker;

import business.entity.Agenzia;
import business.exception.IntegrityException;

public class CheckerAgenzia implements Checker<Agenzia>{

	@Override
	public void check(Agenzia entity) throws IntegrityException {
		if (entity.getId() == 1 || entity.getCitt�() == null || entity.getIndirizzo() == null || entity.getNumTelefono() == null) throw new IntegrityException();
	}

	@Override
	public void isModifiable(Agenzia entity) throws IntegrityException {
		
	}

}
