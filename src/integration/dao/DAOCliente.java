package integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.entity.Cliente;

public class DAOCliente extends DAOCarloan<Cliente>{

	
	public  void create(Cliente entity){
		connection.executeUpdateQuery("insert into persona values(" + entity.toString() + ");");
		connection.executeUpdateQuery("INSERT INTO cliente values(" + entity.getId() + ", '" + entity.getCodicePatente() + "');");
	}
	
	public void update(Cliente entity){
		connection.executeUpdateQuery("update persona set " +
									  "nome = '" + entity.getNome() + "', " +
									  "cognome = '" + entity.getCognome() + "', " +
									  "dataNascita = '" + entity.getDataNascita() + "', " +
									  "numtelefono = '" + entity.getNumTelefono() + "', " +
									  "email = '" + entity.getEMail() + "' where id = "+ entity.getId() + ";");
		connection.executeUpdateQuery("update cliente set codicepatente = '" + entity.getCodicePatente() + "' where id = " + entity.getId());
	}
	
	public Cliente read(String pk){
		Cliente cliente = null;
		ResultSet rs = connection.executeReadQuery("select * from cliente where codicepatente = '" + pk + "';");
		try {
			cliente = new Cliente();
			while(rs.next()){
				cliente.setCodicePatente(pk);
				ResultSet anagrafica = connection.executeReadQuery("select * from persona where id = " + rs.getInt(1) + ";");
				while(anagrafica.next()) {
					cliente.setNome(anagrafica.getString("nome"));
					cliente.setCognome(anagrafica.getString("cognome"));
					cliente.setDataNascita(anagrafica.getString("datanascita"));
					cliente.setNumTelefono(anagrafica.getString("numtelefono"));
					cliente.setEMail(anagrafica.getString("email"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return cliente;
	}
	
	
	public void delete(String pk){
		ResultSet rs = connection.executeReadQuery("select id from cliente where codicepatente = '" + pk + "';");
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				connection.executeUpdateQuery("delete from persona where id = " + id + ";");
			}
		} catch (SQLException e) {

		}
	}
	
	public static void main(String[] args) {
		Cliente a = new Cliente();
		DAOCliente dao = new DAOCliente();
		a.setId(1);
		a.setCodicePatente("1234567890");
		a.setNome("Mario");
		a.setCognome("Rossi");
		a.setNumTelefono("123456789");
		a.setDataNascita("20/07/1994");
		a.setEMail("mariorossi@gmail.com");
		dao.create(a);
		System.out.println(dao.read(a.getCodicePatente()));
		a.setEMail("uidofaidsj@najcksod.com");
		dao.update(a);
		System.out.println(dao.read(a.getCodicePatente()));
		dao.delete(a.getCodicePatente());
		
	}
	
}
