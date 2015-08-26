package business.checker;

import integration.DateHelper;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import business.entity.Contratto;

public class CheckerContratto implements Checker<Contratto>{

	@Override
	public boolean check(Contratto entity) {
		if (entity.getOperatore() == null) return false;
		if (entity.getVettura() == null) return false;
		if (entity.getDataStipula() == null) return false;
		if (entity.getDataInizioNoleggio() == null) return false;
		if (entity.getDataFineNoleggio() == null) return false;
		if (entity.getDataFineNoleggio().isBefore(entity.getDataInizioNoleggio())) return false;
		if (!new CheckerCliente().isAvailable(entity.getCliente(), entity.getDataInizioNoleggio(), entity.getDataFineNoleggio())) return false;
		if (!new CheckerVettura().isAvailable(entity.getVettura(), entity.getDataInizioNoleggio(), entity.getDataFineNoleggio())) return false;
		return true;
	}
	
	@Override
	public boolean isModifiable(Contratto entity) {
		if (LocalDate.now().equals(entity.getDataFineNoleggio()) || 
			LocalDate.now().isAfter(entity.getDataFineNoleggio()) && 
			!entity.isChiuso()) return true;
		if (Days.daysBetween(LocalDate.now(), entity.getDataInizioNoleggio()).getDays() > 2) return true;
		if (!entity.isChiuso()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Contratto a = new Contratto();
		a.setDataInizioNoleggio(DateHelper.dateParse("21/08/2015"));
		System.out.println(new CheckerContratto().isModifiable(a));
	}
}
