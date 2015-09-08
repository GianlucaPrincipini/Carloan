package business.applicationservice;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import integration.Encrypt;
import integration.dao.DAOFactory;
import business.checker.CheckerFactory;
import business.entity.Operatore;
import business.exception.IntegrityException;

public class ApplicationServiceOperatore extends ApplicationServiceEntity<Operatore> implements Gestione<Operatore>{

	@SuppressWarnings("unchecked")
	public ApplicationServiceOperatore() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Operatore.class), CheckerFactory.buildChecker(Operatore.class));
	}

	@Override
	public void create(Operatore entity) {
		try {
			checker.check(entity);
			dao.create(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Operatore entity) {
		try {
			checker.isModifiable(read(entity.getUsername()));
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.update(entity);
	}

	@Override
	public void delete(Operatore entity) {
		try {
			checker.isModifiable(read(entity.getUsername()));
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
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
	
	public boolean login(Operatore operatore) {
		Operatore toLog = dao.read(operatore.getUsername());
		if (toLog != null) {
			try {
				if (toLog.getPassword().equals(Encrypt.getEncryptedString(operatore.getPassword())))
					return true;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
