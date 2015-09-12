package integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.entity.Agenzia;

public class DAOAgenzia extends DAOCarloan<Agenzia>{

	@Override
	public void create(Agenzia entity) {
		connection.executeUpdateQuery("INSERT INTO agenzia(indirizzo, citta, numTelefono)"
									+ " values(" 
									+ "'" + entity.getIndirizzo() + "', " 
									+ "'" + entity.getCittà() + "', "
									+ "'" + entity.getNumTelefono() + "'"
									+ ");");
	}

	@Override
	public void update(Agenzia entity) {
		connection.executeUpdateQuery("UPDATE agenzia SET " +
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
		if (!pk.equals("1"))
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

	@Override
	public List<Agenzia> readAll() {
		List<Agenzia> agenzie = new ArrayList<Agenzia>();
		ResultSet rs = connection.executeReadQuery("select id from agenzia;");
		try {
			while(rs.next()) 
				agenzie.add(read(Integer.toString(rs.getInt("id"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agenzie;
	}
}
