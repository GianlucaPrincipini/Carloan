package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.entity.Fascia;
import business.entity.Modello;
import business.entity.TipoCarburante;

public class SchermataModello extends SchermataDati<Modello>{

	@FXML
	private TextField marca;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField capacit�Bagagliaio;
	
	@FXML
	private TextField numeroPosti;
	
	@FXML
	private TextField potenza;
	
	@FXML
	private TextField emissioniCO2;
	
	@FXML 
	private TextField numeroPorte;
	
	@FXML
	private TextField peso;
	
	@FXML
	private Label fascia;
	
	@FXML
	private ComboBox<TipoCarburante> tipoCarburante;
	
	@FXML
	private CheckBox trasmissioneAutomatica;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoCarburante.setItems(FXCollections.observableArrayList(TipoCarburante.values()));
		tipoCarburante.getSelectionModel().select(0);
	}

	@Override
	public void onConferma() {
		if (edit) {
			controller.processRequest("ModificaModello", buildEntity());
		} else {
			controller.processRequest("AggiungiModello", buildEntity());
		}
		close();
	}

	@Override
	public void initModifica(Modello entity) {
		edit = true;
		id = entity.getId();
		capacit�Bagagliaio.setText(Integer.toString(entity.getCapacit�Bagagliaio()));
		numeroPorte.setText(Integer.toString(entity.getNumeroPorte()));
		numeroPosti.setText(Integer.toString(entity.getNumeroPosti()));
		marca.setText(entity.getMarca());
		nome.setText(entity.getNome());
		emissioniCO2.setText(Double.toString(entity.getEmissioniCO2()));
		potenza.setText(Integer.toString(entity.getPotenza()));
		peso.setText(Integer.toString(entity.getPeso()));
		fascia.setText(Integer.toString(entity.getFascia().getId()));
		trasmissioneAutomatica.selectedProperty().set(entity.isTrasmissioneAutomatica());
	}

	
	@FXML
	public void onCalcolaFascia() {
		fascia.setText(Integer.toString((Integer) controller.processRequest("CalcolaFascia", buildEntity())));
	}
	
	
	@Override
	protected Modello buildEntity() {
		Modello modello = new Modello();
		if (id!=0) {
			modello.setId(id);
		}
		modello.setCapacit�Bagagliaio(Integer.parseInt(capacit�Bagagliaio.getText()));
		modello.setNumeroPorte(Integer.parseInt(capacit�Bagagliaio.getText()));
		modello.setMarca(marca.getText());
		modello.setNome(nome.getText());
		modello.setEmissioniCO2(Double.parseDouble(emissioniCO2.getText()));
		modello.setNumeroPosti(Integer.parseInt(numeroPosti.getText()));
		modello.setPotenza(Integer.parseInt(potenza.getText()));
		modello.setPeso(Integer.parseInt(peso.getText()));
		modello.setTrasmissioneAutomatica(trasmissioneAutomatica.selectedProperty().get());
		modello.setFascia((Fascia) controller.processRequest("ReadFascia", fascia.getText()));
		return modello;
	}

}