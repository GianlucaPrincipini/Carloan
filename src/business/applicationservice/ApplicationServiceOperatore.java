package business.applicationservice;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import utils.Encrypt;
import integration.dao.DAOFactory;
import business.checker.CheckerFactory;
import business.entity.Operatore;
import business.exception.CarloanException;
import business.exception.IntegrityException;

public class ApplicationServiceOperatore extends ApplicationServiceEntity<Operatore> implements Gestione<Operatore>{

	@SuppressWarnings("unchecked")
	public ApplicationServiceOperatore() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Operatore.class), CheckerFactory.buildChecker(Operatore.class));
	}

	@Override
	public void create(Operatore entity) throws IntegrityException {
		if (dao.read(entity.getUsername()) != null) throw new IntegrityException("Username già in uso");
		checker.check(entity);
		dao.create(entity);
		
	}

	@Override
	public void update(Operatore entity) throws IntegrityException {
		checker.isModifiable(read(entity.getUsername()));
		dao.update(entity);
	}

	@Override
	public void delete(Operatore entity) throws IntegrityException {
		checker.isModifiable(read(entity.getUsername()));
		dao.delete(entity.getUsername());
	}

	@Override
	public List<Operatore> readAll() {
		return dao.readAll();
	}

	@Override
	public Operatore read(String pk) {
		return dao.read(pk);
	}
	
	public boolean login(Operatore operatore) throws NoSuchAlgorithmException, UnsupportedEncodingException, CarloanException {
		Operatore toLog = dao.read(operatore.getUsername());
		if (toLog != null) {
			if (toLog.getPassword().equals(Encrypt.getEncryptedString(operatore.getPassword())))
				return true;
		}
		throw new CarloanException("Impossibile effettuare il login, assicurarsi che username e password siano corretti");
	}

}
