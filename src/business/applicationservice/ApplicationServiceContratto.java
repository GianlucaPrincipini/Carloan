package business.applicationservice;

import integration.dao.DAOFactory;

import java.util.List;

import org.joda.time.Days;

import business.checker.CheckerFactory;
import business.checker.ContrattoChecker;
import business.entity.Contratto;

public class ApplicationServiceContratto extends ApplicationServiceEntity<Contratto> implements Gestione<Contratto>{

	
	
	@SuppressWarnings("unchecked")
	protected ApplicationServiceContratto() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Contratto.class), CheckerFactory.buildChecker(Contratto.class));
	}

	@Override
	public void create(Contratto entity) {
		if(checker.check(entity)) 
			dao.create(entity);
	}

	@Override
	public Contratto read(String pk) {
		return dao.read(pk);
	}

	@Override
	public void update(Contratto entity) {
		if (((ContrattoChecker)checker).isModifiable(entity))
			dao.update(entity);
	}


	@Override
	public List<Contratto> readAll() {
		return dao.readAll();
	}

	@Override
	public void delete(Contratto entity) {
		if (((ContrattoChecker)checker).isModifiable(entity))
			dao.delete(Integer.toString(entity.getId()));
	}
	
	public double calcolaCosto(Contratto contratto) {
		double costo = 0;
		// il tariffario è vuoto all'inizio!
		//costo += contratto.getVettura().getModello().getFascia().getTariffaBase();
		if (contratto.isAssicurazioneAvanzata())
			costo += contratto.getTariffario().getAssicurazioneAvanzata();
		else 
			costo += contratto.getTariffario().getAssicurazioneBase();
		if (contratto.isChilometraggioLimitato()) 
			costo += contratto.getTariffario().getCostoChilometrico() * contratto.getChilometraggio();
		else
			costo += 50;
		
		costo += contratto.getTariffario().getCostoGiornaliero() * 
				Days.daysBetween(contratto.getDataInizioNoleggio(), contratto.getDataFineNoleggio()).getDays();
		
		// eccetera eccetera
		costo -= contratto.getAcconto();
		contratto.setCosto(costo);
		update(contratto);
		return costo;
	}
	
	public static void main(String [] args) {
		try {
			ApplicationServiceContratto ac = new ApplicationServiceContratto();
			Contratto contratto = ac.read(Integer.toString(1));
			ac.calcolaCosto(contratto);
			System.out.println(contratto.getCosto());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
