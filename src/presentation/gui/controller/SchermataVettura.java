package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import business.entity.Agenzia;
import business.entity.Modello;
import business.entity.Vettura;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SchermataVettura extends SchermataDati<Vettura>{

	@FXML
	private TextField targa;
	
	@FXML
	private TextField chilometraggio;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox stato;
	
	@FXML
	private Label agenziaLocalizzazione;
	
	@FXML
	private Label modello;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML
	@Override
	public void onConferma() {
		Vettura vettura = new Vettura();
		vettura.setChilometraggio(Integer.parseInt(chilometraggio.getText()));
		vettura.setAgenziaLocalizzazione((Agenzia) controller.processRequest("ReadAgenzia", agenziaLocalizzazione.getText()));
		vettura.setModello((Modello) controller.processRequest("ReadModello", modello.getText()));
		vettura.setTarga(targa.getText());
		if (edit) {
			controller.processRequest("ModificaVettura", vettura);
		} else {
			controller.processRequest("AggiungiVettura", vettura);
		}
		close();
	}


	@Override
	public void initModifica(Vettura entity) {
		edit = true;
		targa.setText(entity.getTarga());
		modello.setText(Integer.toString(entity.getModello().getId()));
		agenziaLocalizzazione.setText(Integer.toString(entity.getAgenziaLocalizzazione().getId()));
		chilometraggio.setText(Integer.toString(entity.getChilometraggio()));
	}

}
