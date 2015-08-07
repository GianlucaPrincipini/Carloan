package integration.dao;

import java.sql.ResultSet;

import business.entity.Modello;
import business.entity.StatoVettura;
import business.entity.Vettura;

public class DAOVettura extends DAOCarloan<Vettura> {

	@Override
	public void create(Vettura entity) {
		connection.executeUpdateQuery("insert into vettura values("+ entity +");");
	}

	@Override
	public void update(Vettura entity) {
		connection.executeUpdateQuery("update vettura set" + 
									  "agenzialocalizzazione = " + entity.getAgenziaLocalizzazione().getIdAgenzia() + ", " +
									  "chilometraggio = " + entity.getChilometraggio() + ", " +
									  "stato = " + entity.getStato().getIndex() + " where targa = '" + entity.getTarga() + "';");	
	}

	@Override
	public Vettura read(String pk) {
		Vettura vettura = null;
		try {
			vettura = new Vettura();
			ResultSet rs = connection.executeReadQuery("select * from vettura where targa = '" + pk + "';"); 
			while(rs.next()) {
				vettura.setTarga(rs.getString("targa"));
				vettura.setAgenziaLocalizzazione(new DAOAgenzia().read(Integer.toString(rs.getInt("agenzialocalizzazione"))));
				vettura.setModello(new DAOModello().read(Integer.toString(rs.getInt("modello"))));
				vettura.setChilometraggio(rs.getInt("chilometraggio"));
				vettura.setStato(StatoVettura.getStato(rs.getInt("stato")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String pk) {
		connection.executeUpdateQuery("delete from vettura where id = '" + pk + "';");
	}
	
	public static void main(String [] args) {
		Vettura a = new Vettura();
		a.setModello(new DAOModello().read(Integer.toString(1)));
		a.setTarga("AB178BR");
		DAOVettura dao = new DAOVettura();
		dao.create(a);
		System.out.println(dao.read("AB178BR"));
	}

}
