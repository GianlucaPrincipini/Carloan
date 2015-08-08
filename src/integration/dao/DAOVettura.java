package integration.dao;

import java.sql.ResultSet;

import business.entity.Agenzia;
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
		connection.executeUpdateQuery("update vettura set " + 
									  "agenzialocalizzazione = " + entity.getAgenziaLocalizzazione().getId() + ", " +
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
		return vettura;
	}

	@Override
	public void delete(String pk) {
		connection.executeUpdateQuery("delete from vettura where targa = '" + pk + "';");
	}
	
	public static void main(String [] args) {
		Vettura a = new Vettura();
		a.setAgenziaLocalizzazione(new DAOAgenzia().read(Integer.toString(1)));
		a.setModello(new DAOModello().read(Integer.toString(1)));
		a.setTarga("AB178BR");
		a.setChilometraggio(120);
		a.setStato(StatoVettura.DISPONIBILE);
		DAOVettura dao = new DAOVettura();
		dao.create(a);		
		System.out.println(dao.read(a.getTarga()));
		a.setChilometraggio(152);
		dao.update(a);
		System.out.println(dao.read(a.getTarga()));
		//dao.delete(a.getTarga());
	}

}
