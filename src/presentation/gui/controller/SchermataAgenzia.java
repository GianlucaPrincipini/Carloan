package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.entity.Agenzia;

public class SchermataAgenzia extends SchermataDati<Agenzia>{

	private FrontController controller;
	
	@FXML
	private TextField citt�;
	
	@FXML
	private TextField indirizzo;
	
	@FXML
	private TextField numTelefono;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = CarloanFrontController.getInstance();		
	}

	@FXML
	@Override
	public void onConferma() {
		Agenzia agenzia = new Agenzia();
		if (id != 0) {
			agenzia.setId(id);
		}
		agenzia.setCitt�(citt�.getText());
		agenzia.setIndirizzo(indirizzo.getText());
		agenzia.setNumTelefono(numTelefono.getText());
		if (edit) {
			controller.processRequest("ModificaAgenzia", agenzia);
		} else {
			controller.processRequest("AggiungiAgenzia", agenzia);
		}
		close();
	}

	@Override
	public void initModifica(Agenzia entity) {
		edit = true;
		id = entity.getId();
		citt�.setText(entity.getCitt�());
		indirizzo.setText(entity.getIndirizzo());
		numTelefono.setText(entity.getNumTelefono());
	}

}
