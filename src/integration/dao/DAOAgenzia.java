package integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Agenzia;

public class DAOAgenzia extends DAOCarloan<Agenzia>{

	@Override
	public void create(Agenzia entity) {
		connection.executeUpdateQuery("INSERT INTO agenzia values(" + entity +  ");");
	}

	@Override
	public void update(Agenzia entity) {
		connection.executeUpdateQuery("UPDATE agenzia SET idAgenzia = " + entity.getIdAgenzia() + ", " +
									  "indirizzo = '" + entity.getIndirizzo() + "', " +
									  "citta = '" + entity.getCittà() + "', " + 
									  "numTelefono = '" + entity.getNumTelefono() + "' " 
									  + "WHERE idAgenzia = '" + entity.getIdAgenzia() + "'; ");
	}

	@Override
	public Agenzia read(String pk) {
		Agenzia agenzia = null;
		ResultSet rs = connection.executeReadQuery("SELECT idAgenzia, indirizzo, citta, numTelefono FROM agenzia WHERE idAgenzia = '" + pk + "';");
		try {
			agenzia = new Agenzia();
			while (rs.next()) {
				agenzia.setIdAgenzia(rs.getInt("idagenzia"));
				agenzia.setIndirizzo(rs.getString("indirizzo"));
				agenzia.setCittà(rs.getString("citta"));
				agenzia.setNumTelefono(rs.getString("numtelefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agenzia;
	}

	@Override
	public void delete(String pk) {
		connection.executeUpdateQuery("DELETE FROM agenzia WHERE idAgenzia = " + pk + ";");
	}
	

}
