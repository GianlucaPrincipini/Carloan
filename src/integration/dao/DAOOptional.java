package integration.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Optional;

public class DAOOptional extends DAOCarloan<Optional>{
	
	
	public Optional read(String pk){
		Optional optional = null;
		ResultSet rs = connection.executeReadQuery("SELECT * FROM optional WHERE codice = '" + pk + "';");
		try {
			optional = new Optional();
			while(rs.next()) {
				optional.setCodice(rs.getString(1));
				optional.setTipo(rs.getString(2));
				optional.setCosto(rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}
	
	public void delete(String pk){
		connection.executeUpdateQuery("delete from optional where codice = '" + pk + "';");
	}

	@Override
	public void create(Optional entity) {
		connection.executeUpdateQuery("INSERT INTO optional values(" + entity.toString() + ");");
	}

	@Override
	public void update(Optional entity) {
		connection.executeUpdateQuery("update optional set " +
									  "codice = '" + entity.getCodice() + "', " +
									  "tipo = '" + entity.getTipo() + "', " +
									  "costo = " + entity.getCosto() + "where codice = '" + entity.getCodice() + "';");

	}

}
