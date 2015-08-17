package integration.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.entity.Optional;

public class DAOOptional extends DAOCarloan<Optional>{
	
	
	public Optional read(String pk){
		Optional optional = null;
		ResultSet rs = connection.executeReadQuery("SELECT * FROM optional WHERE id = " + pk + ";");
		try {
			optional = new Optional();
			while(rs.next()) {
				optional.setId(rs.getInt(1));
				optional.setTipo(rs.getString(2));
				optional.setCosto(rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}
	
	public void delete(String pk){
		connection.executeUpdateQuery("delete from optional where id = " + pk + ";");
	}

	@Override
	public void create(Optional entity) {
		connection.executeUpdateQuery("INSERT INTO optional(tipo, costo) values(" 
									+ "'" + entity.getTipo() + "', "
									+ entity.getCosto()
									+ ");");
	}

	@Override
	public void update(Optional entity) {
		connection.executeUpdateQuery("update optional set " +
									  "tipo = '" + entity.getTipo() + "', " +
									  "costo = " + entity.getCosto() + "where id = '" + entity.getId() + "';");
	}
	
	public static void main(String[] args) {
		// Cambia i float in double, id in contratto e optional
		Optional a = new Optional();
		DAOOptional dao = new DAOOptional();
		a.setId(1);
		a.setTipo("Autoradio");
		a.setCosto(20.5);
		dao.create(a);
		System.out.println(dao.read(Integer.toString(a.getId())));
		a.setCosto(20.90);
		dao.update(a);
		System.out.println(dao.read(Integer.toString(a.getId())));
		//dao.delete(Integer.toString(a.getId()));
	}

	@Override
	public List<Optional> readAll() {
		List<Optional> optional = new ArrayList<Optional>();
		ResultSet rs = connection.executeReadQuery("select id from optional;");
		try {
			while(rs.next()) optional.add(read(Integer.toString(rs.getInt("id"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

}
