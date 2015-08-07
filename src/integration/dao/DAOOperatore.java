package integration.dao;

import integration.Encrypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Agenzia;
import business.entity.Amministratore;
import business.entity.Operatore;

public class DAOOperatore extends DAOCarloan<Operatore> {
	
	public  void create(Operatore entity){
		try {
			connection.executeUpdateQuery("insert into persona  values("+ entity.toStringAsPersona() + ");");
			connection.executeUpdateQuery("insert into profilo(id, username, password) values( " + entity.getId() + ", '" + entity.getUsername() + "', '" + Encrypt.getEncryptedString(entity.getPassword()) + "');");
			if (entity instanceof Amministratore)
				connection.executeUpdateQuery("INSERT INTO Operatore values('" + entity.getUsername() + "', " + entity.getAgenzia().getIdAgenzia() + ", true);");
			else 
				connection.executeUpdateQuery("INSERT INTO Operatore values('" + entity.getUsername() + "', " + entity.getAgenzia().getIdAgenzia() + ", false);");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

	public void update(Operatore entity){
		try {
			connection.executeUpdateQuery("update persona set " +
										  "nome = '" + entity.getNome() + "', " +
										  "cognome = '" + entity.getCognome() + "', " +
										  "dataNascita = '" + entity.getDataNascita() + "', " +
										  "numtelefono = '" + entity.getNumTelefono() + "', " +
										  "email = '" + entity.getEMail() + "' where id = "+ entity.getId() + ";");

			connection.executeUpdateQuery("update profilo set " +
										  "agenzia = " + entity.getId()+ ", " +
										  "password = '" + Encrypt.getEncryptedString(entity.getPassword()) + "' " + "where username = '"+ entity.getUsername() + "';");
			if (entity instanceof Amministratore)
				connection.executeUpdateQuery("update operatore set agenzia = " + entity.getAgenzia().getIdAgenzia() + ", amministratore = 1 where username = '" + entity.getUsername() + "';");
			else 
				connection.executeUpdateQuery("update operatore set agenzia = " + entity.getAgenzia().getIdAgenzia() + ", amministratore = 0 where username = '" + entity.getUsername() + "';");

		} catch (Exception e) {
			System.err.println("Error in encrypting...");
		}
	}
	
	public Operatore read(String pk){
		Operatore operatore= null;
		ResultSet rs = connection.executeReadQuery("select * from operatore inner join profilo on operatore.username = profilo.username where operatore.username = '" + pk + "';");
		try {
			while(rs.next()){
				if (rs.getInt("amministratore") == 1)
					operatore = new Amministratore();
				else 
					operatore = new Operatore();
				
				operatore.setUsername(rs.getString("username"));
				operatore.setAgenzia(new DAOAgenzia().read(rs.getString("agenzia")));
				ResultSet anagrafica = connection.executeReadQuery("select * from persona where id = " + rs.getInt("id") + ";");
				while(anagrafica.next()) {
					operatore.setNome(anagrafica.getString("nome"));
					operatore.setCognome(anagrafica.getString("cognome"));
					operatore.setDataNascita(anagrafica.getString("datanascita"));
					operatore.setNumTelefono(anagrafica.getString("numtelefono"));
					operatore.setEMail(anagrafica.getString("email"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return operatore;
	}
	public void delete(String pk){
		
		//connection.executeUpdateQuery("DELETE FROM operatore WHERE username = '" + pk + "';");
		ResultSet tmp = connection.executeReadQuery("select id from profilo where username = '" + pk + "';");
		try {
			while(tmp.next()) {
				connection.executeUpdateQuery("delete from persona where id = " + tmp.getInt("id") + ";");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DAOOperatore dao = new DAOOperatore();
		Operatore a = new Operatore(); 
		a.setId(1);
		a.setUsername("MarioRossi21");
		a.setPassword("carloan");
		a.setNome("Mario");
		a.setCognome("Rossi");
		a.setDataNascita("20/07/1994");
		a.setEMail("mariorossi@gmail.com");
		


		DAOAgenzia daoag = new DAOAgenzia();
		Agenzia ag = new Agenzia();
		ag.setIdAgenzia(1);
		ag.setIndirizzo("via razzi");
		ag.setCittà("bari");
		ag.setNumTelefono("0881686333");
		a.setAgenzia(ag);
		dao.delete(a.getUsername());
		daoag.delete(Integer.toString(ag.getIdAgenzia()));
		daoag.create(ag);
		dao.create(a);
		System.out.println(dao.read(a.getUsername()));
		a.setEMail("mib777@gmail.com");
		dao.update(a);
		System.out.println(dao.read(a.getUsername()));

	}
	
}
