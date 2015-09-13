package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.entity.Optional;

public class SchermataOptional extends SchermataDati<Optional>{

	@FXML
	private TextField tipo;
	
	@FXML
	private TextField costo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	public void onConferma() {
		if (edit) {
			controller.processRequest("ModificaOptional", buildEntity());
		} else {
			controller.processRequest("AggiungiOptional", buildEntity());
		}
		close();
	}

	@Override
	public void initModifica(Optional entity) {
		edit = true;
		id = entity.getId();
		tipo.setText(entity.getTipo());
		costo.setText(Double.toString(entity.getCosto()));
	}

	@Override
	protected Optional buildEntity() {
		Optional optional = new Optional();
		optional.setId(id);
		optional.setTipo(tipo.getText());
		optional.setCosto(Double.parseDouble(costo.getText()));
		return optional;
	}

}
