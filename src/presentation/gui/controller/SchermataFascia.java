package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.entity.Fascia;

public class SchermataFascia extends SchermataDati<Fascia>{

	@FXML
	private TextField nome;

	@FXML
	private TextField tariffaBase;
	
	@FXML
	private TextField indiceMinimo;
	
	@FXML
	private TextField indiceMassimo;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onConferma() {
		Fascia fascia = buildEntity();
		if (fascia != null) {
			if (edit) controller.processRequest("ModificaFascia", fascia);
			else controller.processRequest("AggiungiFascia", fascia);
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initModifica(Fascia entity) {
		edit = true;
		setId(entity.getId());
		nome.setText(entity.getNome());
		tariffaBase.setText(Double.toString(entity.getTariffaBase()));
		indiceMinimo.setText(Double.toString(entity.getMin()));
		indiceMassimo.setText(Double.toString(entity.getMax()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Fascia buildEntity() {
		Fascia fascia = new Fascia();
		try {
			fascia.setId(id);
			fascia.setNome(nome.getText());
			fascia.setTariffaBase(Double.parseDouble(tariffaBase.getText()));
			fascia.setMax(Double.parseDouble(indiceMassimo.getText()));
			fascia.setMin(Double.parseDouble(indiceMinimo.getText()));
			return fascia;
		} catch (Exception e) {
			return null;
		}
	}

}
