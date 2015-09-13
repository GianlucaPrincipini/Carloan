package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.entity.IncidenzaFascia;
import business.exception.IncidenceOutOfBoundException;

public class SchermataIncidenzaFascia extends SchermataDati<IncidenzaFascia> {

	
	@FXML
	private TextField capacit‡Bagagliaio;

	@FXML
	private TextField numeroPorte;
	
	@FXML
	private TextField numeroPosti;
	
	@FXML
	private TextField potenzaSuPeso;
	
	@FXML
	private TextField emissioniCO2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	@Override
	public void onConferma() {
			controller.processRequest("ModificaIncidenza", buildEntity());
			close();
	}

	@Override
	public void initModifica(IncidenzaFascia entity) {
		edit = true;
		capacit‡Bagagliaio.setText(Double.toString(entity.getCapacit‡Bagagliaio()));
		emissioniCO2.setText(Double.toString(entity.getEmissioniCO2()));
		numeroPorte.setText(Integer.toString(entity.getNumeroPorte()));
		numeroPosti.setText(Integer.toString(entity.getNumeroPosti()));
		potenzaSuPeso.setText(Double.toString(entity.getPotenzaSuPeso()));
		controller.processRequest("ModificaIncidenza", entity);
	}

	@Override
	protected IncidenzaFascia buildEntity() {
		IncidenzaFascia incidenza = IncidenzaFascia.getInstance();
		try {
			incidenza.setCapacit‡Bagagliaio(Double.parseDouble(capacit‡Bagagliaio.getText()));
			incidenza.setEmissioniCO2(Double.parseDouble(emissioniCO2.getText()));
			incidenza.setNumeroPorte(Integer.parseInt(numeroPorte.getText()));
			incidenza.setNumeroPosti(Integer.parseInt(numeroPosti.getText()));
			incidenza.setPotenzaSuPeso(Double.parseDouble(potenzaSuPeso.getText()));
		} catch (NumberFormatException | IncidenceOutOfBoundException e) {
			e.printStackTrace();
		}
		return incidenza;
	}
}
