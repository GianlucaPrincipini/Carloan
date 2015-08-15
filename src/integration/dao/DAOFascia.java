package integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
									  "tariffaBase = " + entity.getTariffaBase() + ", " +
									  "indiceMin = " + entity.getMin() + ", " + 
									  "indiceMax = " + entity.getMax() + " where id = " + entity.getId() + ";");
		
	}

	@Override
	public Fascia read(String pk) {
		Fascia fascia = new Fascia();
		ResultSet rs = connection.executeReadQuery("select * from fascia where id = " + pk + ";");
		try {
			while (rs.next()) {
				fascia.setId(rs.getInt("id"));
				fascia.setMax(rs.getDouble("indiceMax"));
				fascia.setMin(rs.getDouble("indiceMin"));
				fascia.setNome(rs.getString("nome"));
				fascia.setTariffaBase(rs.getDouble("tariffaBase"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fascia;
	}

	@Override
	public void delete(String pk) {
		if (!pk.equals(1)) {
			connection.executeUpdateQuery("delete from fascia where id = " + pk + ";");
		}
	}

	@Override
	public List<Fascia> readAll() {
		ArrayList<Fascia> fasce = new ArrayList<Fascia>();
		ResultSet rs = connection.executeReadQuery("select id from fascia;");
		try {
			while(rs.next()) {
				fasce.add(read(Integer.toString(rs.getInt("id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fasce;
	}

	public static void main(String[] args) {
		new DAOFascia().create(new Fascia());
		System.out.println(new DAOFascia().readAll());
		new DAOFascia().delete("0");
	}
	
}
