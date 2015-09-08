package business.checker;

import business.entity.Operatore;
import business.exception.IntegrityException;

public class CheckerOperatore implements Checker<Operatore>{

	@Override
	public void check(Operatore entity) throws IntegrityException {

	}

	@Override
	public void isModifiable(Operatore entity) throws IntegrityException {
	}

}
