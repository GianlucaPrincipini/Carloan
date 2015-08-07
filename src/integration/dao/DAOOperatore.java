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
			connection.executeUpdateQuery("insert into persona(nome, cognome, datanascita, numtelefono, email)  values(" + entity.toStringAsPersona() + ");");
			connection.executeUpdateQuery("insert into profilo(id, username, password) values( " + entity.getId() + ", ' " + entity.getUsername() + "', '" + Encrypt.getEncryptedString(entity.getPassword()) + "');");
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
										  "username = '" + entity.getUsername() + "', " +
										  "password = '" + Encrypt.getEncryptedString(entity.getPassword())+ "', " + "' where id = "+ entity.getId() + ";");
			connection.executeUpdateQuery("update cliente set agenzia = " + entity.getAgenzia().getIdAgenzia() + " where id = " + entity.getId());
		} catch (Exception e) {
			System.err.println("Error in encrypting...");
		}
	}
	
	public Operatore read(String pk){
		Operatore operatore= null;
		ResultSet rs = connection.executeReadQuery("select * from operatore inner join profilo on (operatore.username = profilo.username) where operatore.username = '" + pk + "';");
		try {
			if (rs.getBoolean("amministratore"))
				operatore = new Amministratore();
			else 
				operatore = new Operatore();
			
			while(rs.next()){
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
		connection.executeUpdateQuery("DELETE FROM operatore WHERE username = '" + pk + "';");
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
		

		System.out.println("Test");
		DAOAgenzia daoag = new DAOAgenzia();
		Agenzia ag = new Agenzia();
		ag.setIdAgenzia(1);
		ag.setIndirizzo("via razzi");
		ag.setCitt�("bari");
		ag.setNumTelefono("0881686333");
		a.setAgenzia(ag);
		dao.delete(a.getUsername());
		daoag.delete(Integer.toString(ag.getIdAgenzia()));
		daoag.create(ag);
		dao.create(a);
		System.out.println(dao.read(Integer.toString(1)));
	}
	
}
