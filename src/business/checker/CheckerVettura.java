package business.checker;

import java.util.List;

import integration.dao.DAOContratto;

import org.joda.time.LocalDate;

import business.entity.Contratto;
import business.entity.StatoVettura;
import business.entity.Vettura;
import business.exception.IntegrityException;

public class CheckerVettura implements Checker<Vettura>{

	@Override
	public void check(Vettura entity) throws IntegrityException {
		if (entity.getTarga() == null) throw new IntegrityException("Targa non inserita");
		if (entity.getModello() == null) throw new IntegrityException("Modello non specificato");
		if (entity.getAgenziaLocalizzazione() == null) throw new IntegrityException("Agenzia di localizzazione non indicata");
		if (entity.getStato() == null) throw new IntegrityException("Stato della vettura non indicato");
	}

	@Override
	public void isModifiable(Vettura entity) throws IntegrityException {
		if (!isAvailable(entity, LocalDate.now(), LocalDate.now()))
			throw new IntegrityException();
	}
	
	public boolean isAvailable(Vettura entity, LocalDate inizio, LocalDate fine) {
		if (inizio == LocalDate.now() && fine == LocalDate.now()) {
			if (entity.getStato() == StatoVettura.DISPONIBILE) return true;
			else return false;
		} else {
			List<Contratto> contratti = new DAOContratto().readAll();
			for (Contratto c:contratti) {
				if (c.getVettura().getTarga().equals(entity.getTarga())) {
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
		}
		return true;
	}

}
