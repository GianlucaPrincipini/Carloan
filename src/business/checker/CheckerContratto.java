package business.checker;

import integration.DateHelper;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import business.entity.Contratto;
import business.exception.IntegrityException;
import business.exception.UnmodifiableEntityException;

public class CheckerContratto implements Checker<Contratto>{

	@Override
	public void check(Contratto entity) throws IntegrityException {
		if (entity.getOperatore() == null) throw new IntegrityException();
		if (entity.getVettura() == null) throw new IntegrityException();
		if (entity.getDataStipula() == null) throw new IntegrityException();
		if (entity.getDataInizioNoleggio() == null) throw new IntegrityException();
		if (entity.getDataFineNoleggio() == null) throw new IntegrityException();
		if (entity.getDataFineNoleggio().isBefore(entity.getDataInizioNoleggio())) throw new IntegrityException();
		if (!new CheckerCliente().isAvailable(entity.getCliente(), entity.getDataInizioNoleggio(), entity.getDataFineNoleggio())) throw new IntegrityException();
		if (!new CheckerVettura().isAvailable(entity.getVettura(), entity.getDataInizioNoleggio(), entity.getDataFineNoleggio())) throw new IntegrityException();
	}
	
	@Override
	public void isModifiable(Contratto entity) throws UnmodifiableEntityException {
		
		if ((LocalDate.now().equals(entity.getDataFineNoleggio()) || 
			LocalDate.now().isAfter(entity.getDataFineNoleggio())) && 
			!entity.isChiuso()) return;
		if (Days.daysBetween(LocalDate.now(), entity.getDataInizioNoleggio()).getDays() > 2) return;
		if (!entity.isChiuso()) return;
		throw new UnmodifiableEntityException();
	}
	
	public static void main(String[] args) {
		Contratto a = new Contratto();
		a.setDataInizioNoleggio(DateHelper.dateParse("21/08/2015"));
	}
}
