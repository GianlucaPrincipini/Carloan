package business.applicationservice;

import integration.dao.DAOFactory;

import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import business.checker.CheckerFactory;
import business.checker.CheckerContratto;
import business.entity.Agenzia;
import business.entity.Contratto;
import business.entity.Optional;
import business.entity.Rifornimento;
import business.entity.Tariffario;
import business.exception.IntegrityException;

public class ApplicationServiceContratto extends ApplicationServiceEntity<Contratto> {

	public void chiudi(Contratto contratto) {
		if (!contratto.isChiuso()) {
			contratto.setDataChiusura(LocalDate.now());
			contratto.setChiuso(true);
			calcolaCosto(contratto);
			update(contratto);
			// da rivedere
		} 
	}
	
	@SuppressWarnings("unchecked")
	protected ApplicationServiceContratto() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Contratto.class), CheckerFactory.buildChecker(Contratto.class));
	}

	@Override
	public void create(Contratto entity) {
		try {
			checker.check(entity);
			dao.create(entity);
		} catch (IntegrityException e) {
			e.showError();
		} 
	}

	@Override
	public Contratto read(String pk) {
		return dao.read(pk);
	}

	@Override
	public void update(Contratto entity) {
		try {
			checker.isModifiable(dao.read(Integer.toString(entity.getId())));
			checker.check(entity);
			dao.update(entity);
		} catch (IntegrityException e){
			e.showError();
		}
	}

	@Override
	public List<Contratto> readAll() {
		return dao.readAll();
	}

	@Override
	public void delete(Contratto entity) {
		try {
			checker.isModifiable(read(Integer.toString(entity.getId())));
			dao.delete(Integer.toString(entity.getId()));
		} catch (IntegrityException e) {
			e.showError();
		}
	}
	
	
	public double calcolaCosto(Contratto contratto) {
		double costo = 0;
		Tariffario tariffario = contratto.getTariffario();
		// il tariffario è vuoto all'inizio!
		costo += contratto.getVettura().getModello().getFascia().getTariffaBase();
		for (Optional o:contratto.getOptionals()) {
			costo += o.getCosto();
		}
		int durataNoleggio = Days.daysBetween(contratto.getDataInizioNoleggio(), contratto.getDataFineNoleggio()).getDays();
		if (durataNoleggio % 7 == 0) 
			costo += durataNoleggio/7 * tariffario.getCostoSettimanale();
		else 
			costo += durataNoleggio * tariffario.getCostoGiornaliero();
		
		if (contratto.isAssicurazioneAvanzata())
			costo += tariffario.getAssicurazioneAvanzata();
		else 
			costo += tariffario.getAssicurazioneBase();

		if (contratto.isChilometraggioLimitato()) {
			costo += tariffario.getCostoChilometrico() * contratto.getChilometriPrevisti();
		} else {
			costo += tariffario.getCostoChilometraggioIllimitato();
		}
		
		if (contratto.isChiuso()) {
			int chilometriConsiderati;
			if (contratto.isChilometraggioLimitato() && contratto.getChilometriPercorsi() <= contratto.getChilometriPrevisti())
				chilometriConsiderati = contratto.getChilometriPrevisti();
			else chilometriConsiderati = contratto.getChilometriPercorsi();
			
			if (contratto.getRifornimento() == Rifornimento.STANDARD) {
				costo += tariffario.getCostoLitro(contratto.getVettura().getModello().getTipoCarburante()) * chilometriConsiderati;
			} else if (contratto.getRifornimento() == Rifornimento.PIENO_ANTICIPO) {
				costo += tariffario.getRifornimento(contratto.getRifornimento());
			} 
			
			if (contratto.getDataChiusura().isAfter(contratto.getDataFineNoleggio())) {
				costo += tariffario.getMoraDurata() * Days.daysBetween(contratto.getDataFineNoleggio(), contratto.getDataChiusura()).getDays();
			}
			
			if (contratto.isChilometraggioLimitato() && contratto.getChilometriPercorsi() > contratto.getChilometriPrevisti()) {
				costo += tariffario.getMoraChilometraggio() * (contratto.getChilometriPercorsi() - contratto.getChilometriPrevisti());
			}
		}
		
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

	public List<Contratto> filtra(Agenzia agenzia) {
		List<Contratto> contrattiFiltrati = readAll();
		for (Contratto c:contrattiFiltrati) {
			if (c.getAgenziaConsegna().getId() != agenzia.getId() && c.getAgenziaNoleggio().getId() != agenzia.getId()) {
				contrattiFiltrati.remove(c);
			}
		}
		return contrattiFiltrati;
	}
}
