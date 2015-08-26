package business.checker;

import java.util.List;

import integration.dao.DAOContratto;

import org.joda.time.LocalDate;

import business.entity.Contratto;
import business.entity.StatoVettura;
import business.entity.Vettura;

public class CheckerVettura implements Checker<Vettura>{

	@Override
	public boolean check(Vettura entity) {
		if (entity.getTarga() == null) return false;
		if (entity.getModello() == null) return false;
		if (entity.getAgenziaLocalizzazione() == null) return false;
		return true;
	}

	@Override
	public boolean isModifiable(Vettura entity) {
		if (entity.getStato() == StatoVettura.DISPONIBILE) {
			return true;
		}
		return false;
	}
	
	public boolean isAvailable(Vettura entity, LocalDate inizio, LocalDate fine) {
		if (inizio == LocalDate.now() && fine == LocalDate.now()) {
			if (entity.getStato() == StatoVettura.DISPONIBILE) return true;
			else return false;
		} else {
			List<Contratto> contratti = new DAOContratto().readAll();
			for (Contratto c:contratti) {
				if (inizio.isBefore(c.getDataFineNoleggio()) && fine.isAfter(c.getDataInizioNoleggio())) {
					return false;
				}
				if (inizio.isBefore(c.getDataInizioNoleggio()) && fine.isAfter(c.getDataInizioNoleggio())) {
					return false;
				}
				if (inizio.isAfter(c.getDataInizioNoleggio()) && inizio.isBefore(c.getDataFineNoleggio())) {
					return false;
				}
			}
		}
		return true;
	}

}
