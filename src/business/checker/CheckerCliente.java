package business.checker;

import java.util.List;

import integration.dao.DAOContratto;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import business.entity.Cliente;
import business.entity.Contratto;

public class CheckerCliente implements Checker<Cliente>{

	@Override
	public boolean check(Cliente entity) {
		if (entity.getCodicePatente() == null) return false;
		if (entity.getNome() == null) return false;
		if (entity.getCognome() == null) return false;
		if (Years.yearsBetween(entity.getDataNascita(), LocalDate.now()).getYears() < 18) return false;
		return true;
	}

	@Override
	public boolean isModifiable(Cliente entity) {
		// Un cliente può essere modificato se non ha un noleggio attivo
		return isAvailable(entity, LocalDate.now(), LocalDate.now());
	}
	
	/**
	 * Funzione che verifica se un cliente è disponibile nell'intervallo di tempo
	 * @param entity cliente
	 * @param inizio data inizio periodo di verifica
	 * @param fine data fine periodo di verifica
	 * @return vero se il cliente ha un noleggio attivo nell'intervallo di tempo tra inizio e fine
	 */
	public boolean isAvailable(Cliente entity, LocalDate inizio, LocalDate fine) {
		List<Contratto> contratti = new DAOContratto().readAll();
		for (Contratto c:contratti) {
			if (c.getCliente().equals(entity)) {
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
