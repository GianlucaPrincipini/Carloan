package business.checker;

import business.entity.Modello;
import business.exception.IntegrityException;

public class CheckerModello implements Checker<Modello>{

	@Override
	public void check(Modello entity) throws IntegrityException {
		if (entity.getId() == 0) throw new IntegrityException("Id mancante");;
		if (entity.getMarca() == null) throw new IntegrityException("Marca mancante");;
		if (entity.getNome() == null) throw new IntegrityException("Nome mancante");
		if (entity.getTipoCarburante() == null) throw new IntegrityException("Tipo carburante mancante");
		if (entity.getFascia() == null) throw new IntegrityException("Fascia mancante");
		if (entity.getPeso() == 0 ) throw new IntegrityException("peso mancante");
		if (entity.getPotenza() == 0) throw new IntegrityException("potenza mancante");
	}

	@Override
	public void isModifiable(Modello entity) {
		
	}

}
