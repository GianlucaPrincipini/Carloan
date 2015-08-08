package integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Agenzia;

public class DAOAgenzia extends DAOCarloan<Agenzia>{

	@Override
	public void create(Agenzia entity) {
		connection.executeUpdateQuery("INSERT INTO agenzia values(" + entity + ");");
	}

	@Override
	public void update(Agenzia entity) {
		connection.executeUpdateQuery("UPDATE agenzia SET idAgenzia = " + entity.getId() + ", " +
									  "indirizzo = '" + entity.getIndirizzo() + "', " +
									  "citta = '" + entity.getCittà() + "', " + 
									  "numTelefono = '" + entity.getNumTelefono() + "' " 
									  + "WHERE id = '" + entity.getId() + "'; ");
	}

	@Override
	public Agenzia read(String pk) {
		Agenzia agenzia = null;
		ResultSet rs = connection.executeReadQuery("SELECT * FROM agenzia WHERE id = " + pk + ";");
		try {
			agenzia = new Agenzia();
			while (rs.next()) {
				agenzia.setId(rs.getInt("id"));
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
		connection.executeUpdateQuery("DELETE FROM agenzia WHERE id"
				+ " = " + pk + ";");
	}
	
	public static void main(String[] args) {
		DAOAgenzia daoag = new DAOAgenzia();
		Agenzia ag = new Agenzia();
		ag.setId(1);
		ag.setIndirizzo("via razzi");
		ag.setCittà("bari");
		ag.setNumTelefono("0881686333");
		daoag.create(ag);
	}
}
