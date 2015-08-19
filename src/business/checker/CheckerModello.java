package business.checker;

import business.entity.Modello;

public class CheckerModello implements Checker<Modello>{

	@Override
	public boolean check(Modello entity) {
		if (entity.getId() == 0) return false;
		if (entity.getMarca() == null) return false;
		if (entity.getNome() == null) return false;
		if (entity.getTipoCarburante() == null) return false;
		if (entity.getFascia() != null) return false;
		if (entity.getPeso() == 0 ) return false;
		if (entity.getPotenza() == 0) return false;
		return true;
	}

	@Override
	public boolean isModifiable(Modello entity) {
		return true;
	}

}
