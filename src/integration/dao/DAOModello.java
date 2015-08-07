package integration.dao;



import java.sql.ResultSet;

import business.entity.Modello;
import business.entity.TipoCarburante;

public class DAOModello extends DAOCarloan<Modello> {

	@Override
	public void create(Modello entity) {
		connection.executeUpdateQuery("INSERT INTO modello values(" + entity + ");");
	}

	@Override
	public void update(Modello entity) {
		connection.executeUpdateQuery("UPDATE MODELLO SET id = " + entity.getId() + ", " +
									  "Marca = '" + entity.getMarca() + "', " +
									  "Nome = '" + entity.getNome() + "', " + 
									  "TipoCarburante = " + entity.getTipoCarburante().getIndex() + ", " +
									  "CapacitaBagagliaio = " + entity.getCapacit‡Bagagliaio() + ", " +
									  "NumeroPosti = " + entity.getNumeroPosti() + ", " +
									  "NumeroPorte = " + entity.getNumeroPorte() + ", " +
									  "Potenza = " + entity.getPotenza() + ", " +
									  "TrasmissioneAutomatica = " + entity.isTrasmissioneAutomatica() + ", " +
									  "Peso = " + entity.getPeso() + ", " +
									  "WHERE id = " + entity.getId() + "; ");
	}

	@Override
	public Modello read(String pk) {
		Modello modello = null;
		try {
			modello = new Modello();
			ResultSet rs = connection.executeReadQuery(" SELECT * FROM MODELLO WHERE id = " + pk + ";");
			while(rs.next()) {
				modello.setId(rs.getInt(1));
				modello.setMarca(rs.getString(2));
				modello.setNome(rs.getString(3));
				modello.setTipoCarburante(TipoCarburante.getTipo(rs.getInt(4)));
				modello.setCapacit‡Bagagliaio(rs.getInt(5));
				modello.setNumeroPosti(rs.getInt(6));
				modello.setNumeroPorte(rs.getInt(7));
				modello.setPotenza(rs.getInt(8));
				modello.setTrasmissioneAutomatica(rs.getBoolean(9));
				modello.setEmissioniCO2(rs.getFloat(10));
				modello.setPeso(rs.getInt(11));
			}
		} catch (Exception e) {
			
		}
		return modello;
	}

	@Override
	public void delete(String pk) {
		connection.executeUpdateQuery("DELETE FROM modello WHERE id = " + pk + ";");
	}
	
	public static void main(String [] args) {
		
	}
}
