package business.checker;

import business.entity.Modello;
import business.exception.IntegrityException;

public class CheckerModello implements Checker<Modello>{

	@Override
	public void check(Modello entity) throws IntegrityException {
		if (entity.getId() == 0) throw new IntegrityException();;
		if (entity.getMarca() == null) throw new IntegrityException();;
		if (entity.getNome() == null) throw new IntegrityException();
		if (entity.getTipoCarburante() == null) throw new IntegrityException();
		if (entity.getFascia() != null) throw new IntegrityException();
		if (entity.getPeso() == 0 ) throw new IntegrityException();
		if (entity.getPotenza() == 0) throw new IntegrityException();
	}

	@Override
	public void isModifiable(Modello entity) {
		
	}

}
