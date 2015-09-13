package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import business.entity.Agenzia;
import business.entity.Modello;
import business.entity.StatoVettura;
import business.entity.Vettura;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SchermataVettura extends SchermataDati<Vettura>{

	@FXML
	private TextField targa;
	
	@FXML
	private TextField chilometraggio;
	
	@FXML
	private ChoiceBox<StatoVettura> stato;
	
	@FXML
	private Label agenziaLocalizzazione;
	
	@FXML
	private Label modello;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stato.setItems(FXCollections.observableArrayList(StatoVettura.values()));
		stato.getSelectionModel().select(0);
	}

	@FXML
	@Override
	public void onConferma() {

		if (edit) {
			controller.processRequest("ModificaVettura", buildEntity());
		} else {
			controller.processRequest("AggiungiVettura", buildEntity());
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
		stato.getSelectionModel().select(entity.getStato());
	}

	@FXML
	public void onSelezioneModello() {
		modello.setText((String)controller.processRequest("MostraSelezione", "Modello"));
	}
	
	@FXML
	public void onSelezioneAgenzia() {
		agenziaLocalizzazione.setText((String)controller.processRequest("MostraSelezione", "Agenzia"));
	}
	
	@Override
	protected Vettura buildEntity() {
		Vettura vettura = new Vettura();
		vettura.setChilometraggio(Integer.parseInt(chilometraggio.getText()));
		vettura.setAgenziaLocalizzazione((Agenzia) controller.processRequest("ReadAgenzia", agenziaLocalizzazione.getText()));
		vettura.setModello((Modello) controller.processRequest("ReadModello", modello.getText()));
		vettura.setTarga(targa.getText());
		vettura.setStato(stato.getSelectionModel().getSelectedItem());
		return vettura;
	}

}
