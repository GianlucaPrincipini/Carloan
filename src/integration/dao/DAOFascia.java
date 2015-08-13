package integration.dao;

import java.util.List;

import business.entity.Fascia;

public class DAOFascia extends DAOCarloan<Fascia> {

	@Override
	public void create(Fascia entity) {
		connection.executeUpdateQuery("insert into fascia values ( "+ entity +");");
	}

	@Override
	public void update(Fascia entity) {
		connection.executeUpdateQuery("update fascia set nome = '" + entity.getNome() + "', " +
									  "min = " + entity.getMin() + ", " + 
									  "max = " + entity.getMax() + " where id = " + entity.getId() + ";");
		
	}

	@Override
	public Fascia read(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String pk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fascia> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
