package integration.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import business.entity.Contratto;
import business.entity.Optional;
import business.entity.Rifornimento;

public class DAOContratto extends DAOCarloan<Contratto>{
	
	@Override
	public void create(Contratto entity){
		connection.executeUpdateQuery("INSERT INTO modello values(" + entity + ");");
	}
	
	@Override
	public void update(Contratto entity){
		connection.executeUpdateQuery("UPDATE MODELLO SET idContratto = " + entity.getIdContratto() + ", " +
				  "Operatore = '" + entity.getOperatore().getUsername() + "', " +
				  "Cliente = '" + entity.getCliente().getCodicePatente() + "', " + 
				  "AgenziaNoleggio = " + entity.getAgenziaNoleggio().getIdAgenzia() + ", " +
				  "AgenziaConsegna = " + entity.getAgenziaConsegna().getIdAgenzia() + ", " +
				  "DataStipula = '" + entity.getDataStipula() + "', " +
				  "DataChiusura = '" + entity.getDataChiusura() + "', " +
				  "ChilometraggioLimitato = " + entity.isChilometraggioLimitato() + ", " +
				  "Chilometraggio = " + entity.getChilometraggio() + ", " +
				  "Rifornimento = " + entity.getRifornimento().getIndex() + ", " +
				  "Acconto = " + entity.getAcconto() + ", " +
				  "Chiuso = " + entity.isChiuso() + ", " +
				  "Costo = " + entity.getCosto() + ", " +
				  "AssicurazioneAvanzata = " + entity.isAssicurazioneAvanzata() + ", " +
				  "WHERE id = " + entity.getIdContratto() + "; ");
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
			ResultSet rs = connection.executeReadQuery(" SELECT * FROM MODELLO WHERE id = " + pk + ";");
			while(rs.next()) {
				contratto.setIdContratto(rs.getInt(1));
				contratto.setOperatore(operatore.read(rs.getString(2)));
				contratto.setCliente(cliente.read(rs.getString(3)));
				contratto.setAgenziaNoleggio(agenziaNoleggio.read(rs.getString(4)));
				contratto.setAgenziaConsegna(agenziaConsegna.read(rs.getString(5)));
				contratto.setDataStipula(rs.getString(6));
				contratto.setDataChiusura(rs.getString(7));
				contratto.setChilometraggioLimitato(rs.getBoolean(8));
				contratto.setChilometraggio(rs.getInt(9));
				contratto.setRifornimento(Rifornimento.getRifornimento(rs.getInt(10)));
				contratto.setAcconto(rs.getFloat(11));
				contratto.setChiuso(rs.getBoolean(12));
				contratto.setCosto(rs.getFloat(13));
				contratto.setAssicurazioneAvanzata(rs.getBoolean(14));
				ResultSet rs_optional = connection.executeReadQuery("SELECT codice from optional_contratto where idContratto = " + rs.getInt(1) + ";");
				List<Optional> optionals = new ArrayList<Optional>(); 
				DAOOptional optional = new DAOOptional();
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
		connection.executeUpdateQuery("DELETE FROM contratto WHERE idContratto = " + pk + ";");
	}
}
