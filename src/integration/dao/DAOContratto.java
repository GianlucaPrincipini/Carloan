package integration.dao;

import integration.DateHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.entity.Contratto;
import business.entity.Optional;
import business.entity.Rifornimento;

public class DAOContratto extends DAOCarloan<Contratto>{
	
	@Override
	public void create(Contratto entity){
		connection.executeUpdateQuery("INSERT INTO contratto values(" + entity + ");");
		for (Optional o : entity.getOptionals()) {
			connection.executeUpdateQuery("insert into optional_contratto values (" + entity.getId() + ", " + o.getId() + ");");
		}
	}
	
	@Override
	public void update(Contratto entity){
		connection.executeUpdateQuery("UPDATE contratto SET id = " + entity.getId() + ", " +
				  "Operatore = '" + entity.getOperatore().getUsername() + "', " +
				  "Cliente = '" + entity.getCliente().getCodicePatente() + "', " + 
				  "Vettura = '" + entity.getVettura().getTarga() + "', " +
				  "AgenziaNoleggio = " + entity.getAgenziaNoleggio().getId() + ", " +
				  "AgenziaConsegna = " + entity.getAgenziaConsegna().getId() + ", " +
				  "DataStipula = '" + entity.getDataStipula() + "', " +
				  "DataInizioNoleggio = '" + entity.getDataInizioNoleggio() + "', " +
				  "DataChiusura = '" + entity.getDataChiusura() + "', " +
				  "ChilometraggioLimitato = " + entity.isChilometraggioLimitato() + ", " +
				  "Chilometraggio = " + entity.getChilometraggio() + ", " +
				  "Rifornimento = " + entity.getRifornimento().getIndex() + ", " +
				  "Acconto = " + entity.getAcconto() + ", " +
				  "Chiuso = " + entity.isChiuso() + ", " +
				  "Costo = " + entity.getCosto() + ", " +
				  "AssicurazioneAvanzata = " + entity.isAssicurazioneAvanzata() + " " +
				  "WHERE id = " + entity.getId() + "; ");
	}
	
	@Override
	public Contratto read(String pk){
		Contratto contratto = null;
		DAOOperatore operatore = null;
		DAOCliente cliente = null;
		DAOAgenzia agenziaNoleggio = null;
		DAOAgenzia agenziaConsegna = null;
		
		try {
			contratto = new Contratto();
			operatore = new DAOOperatore();
			cliente = new DAOCliente();
			agenziaNoleggio = new DAOAgenzia();
			agenziaConsegna = new DAOAgenzia();
			ResultSet rs = connection.executeReadQuery("select * from contratto where id = "+ pk + ";");
			while(rs.next()) {
				contratto.setId(rs.getInt("id"));
				contratto.setOperatore(operatore.read(rs.getString("operatore")));
				contratto.setCliente(cliente.read(rs.getString("cliente")));
				contratto.setAgenziaNoleggio(agenziaNoleggio.read(Integer.toString(rs.getInt("agenziaNoleggio"))));
				contratto.setAgenziaConsegna(agenziaConsegna.read(Integer.toString(rs.getInt("agenziaconsegna"))));
				contratto.setDataStipula(DateHelper.dateToLocalDate(rs.getDate("datastipula")));
				contratto.setDataChiusura(DateHelper.dateToLocalDate(rs.getDate("datachiusura")));
				contratto.setDataInizioNoleggio(DateHelper.dateToLocalDate(rs.getDate("datainizionoleggio")));
				contratto.setChilometraggioLimitato(rs.getBoolean("chilometraggiolimitato"));
				contratto.setChilometraggio(rs.getInt("chilometraggio"));
				contratto.setRifornimento(Rifornimento.getRifornimento(rs.getInt("rifornimento")));
				contratto.setAcconto(rs.getFloat("acconto"));
				contratto.setChiuso(rs.getBoolean("chiuso"));
				contratto.setCosto(rs.getFloat("costo"));
				contratto.setVettura(new DAOVettura().read(rs.getString("vettura")));
				contratto.setAssicurazioneAvanzata(rs.getBoolean("assicurazioneAvanzata"));
				ResultSet rs_optional = connection.executeReadQuery("SELECT idOptional from optional_contratto where idContratto = " + rs.getInt(1) + ";");
				List<Optional> optionals = new ArrayList<Optional>(); 
				while(rs_optional.next()) {
					optionals.add(new DAOOptional().read(rs_optional.getString(1)));
				}
				contratto.setOptionals(optionals);
			}
		} catch (Exception e) {
			
		}
		return contratto;
	}
	
	@Override
	public void delete(String pk){
		connection.executeUpdateQuery("DELETE FROM contratto WHERE id = " + pk + ";");
	}
	
	public static void main(String[] args) {
		Contratto a = new Contratto();
		DAOContratto dao = new DAOContratto();
		a.setId(2);
		a.setAgenziaConsegna(new DAOAgenzia().read(Integer.toString(1)));
		a.setAgenziaNoleggio(new DAOAgenzia().read(Integer.toString(1)));
		a.getOptionals().add(new DAOOptional().read(Integer.toString(1)));
		a.setCliente(new DAOCliente().read("1234567890"));
		a.setVettura(new DAOVettura().read("ED000BA"));
		a.setCosto(25.25);
		a.setDataStipula(DateHelper.dateParse("20/08/2015"));
		a.setDataInizioNoleggio(DateHelper.dateParse("25/08/2015"));
		a.setDataChiusura(DateHelper.dateParse("28/08/2015"));
		a.setRifornimento(Rifornimento.PAGAMENTO_RICONSEGNA);
		a.setOperatore(new DAOOperatore().read("Admin"));
		System.out.println(a);
		dao.create(a);
		System.out.println(dao.read(Integer.toString(a.getId())));
		a.setCosto(28.50);
		dao.update(a);
		System.out.println(dao.read(Integer.toString(a.getId())));
		dao.delete(Integer.toString(1));
	}
}
