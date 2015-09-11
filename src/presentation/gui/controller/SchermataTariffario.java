package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import business.entity.Rifornimento;
import business.entity.Tariffario;
import business.entity.TipoCarburante;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SchermataTariffario extends SchermataDati<Tariffario>{

	
	@FXML
	private TextField costoGiornaliero;
	
	@FXML
	private TextField costoSettimanale;
	
	@FXML
	private TextField costoChilometrico;
	
	@FXML
	private TextField costoChilometraggioIllimitato;
	
	@FXML
	private TextField assicurazioneBase;
	
	@FXML
	private TextField assicurazioneAvanzata;
	
	@FXML
	private TextField costoCarburante;
	
	@FXML
	private TextField costoRifornimento;
	
	@FXML
	private TextField moraCarburante;
	
	@FXML
	private TextField moraChilometraggio;
	
	@FXML
	private TextField moraDurata;
	
	@FXML
	private ComboBox<TipoCarburante> carburante;	
	
	@FXML
	private ComboBox<Rifornimento> rifornimento;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		controller = CarloanFrontController.getInstance();
		carburante.setItems(FXCollections.observableArrayList(TipoCarburante.values()));
		rifornimento.setItems(FXCollections.observableArrayList(Rifornimento.values()));
	}

	@Override
	public void onConferma() {
		Tariffario tariffario = Tariffario.getInstance();
		
		tariffario.setCostoGiornaliero(Double.parseDouble(costoGiornaliero.getText())); 
		tariffario.setCostoSettimanale(Double.parseDouble(costoSettimanale.getText()));
		tariffario.setCostoChilometrico(Double.parseDouble(costoChilometrico.getText()));
		tariffario.setCostoChilometraggioIllimitato(Double.parseDouble(costoChilometraggioIllimitato.getText()));
		tariffario.setAssicurazioneBase(Double.parseDouble(assicurazioneBase.getText()));
		tariffario.setAssicurazioneAvanzata(Double.parseDouble(assicurazioneAvanzata.getText()));
		tariffario.setCostoLitro(carburante.getValue(), Double.parseDouble(costoCarburante.getText()));
		tariffario.setRifornimento(rifornimento.getValue(), Double.parseDouble(costoRifornimento.getText()));
		tariffario.setMoraCarburante(Double.parseDouble(costoCarburante.getText()));
		tariffario.setMoraChilometraggio(Double.parseDouble(moraChilometraggio.getText()));
		tariffario.setMoraDurata(Double.parseDouble(moraDurata.getText()));
		
		controller.processRequest("ModificaTariffario", tariffario);
	}

	@Override
	public void initModifica(Tariffario entity) {
		
		costoGiornaliero.setText(Double.toString(entity.getCostoGiornaliero()));
		costoSettimanale.setText(Double.toString(entity.getCostoSettimanale()));
		costoChilometrico.setText(Double.toString(entity.getCostoChilometrico()));
		costoChilometraggioIllimitato.setText(Double.toString(entity.getCostoChilometraggioIllimitato()));
		assicurazioneBase.setText(Double.toString(entity.getAssicurazioneBase()));
		assicurazioneAvanzata.setText(Double.toString(entity.getAssicurazioneAvanzata()));
		costoCarburante.setText(Double.toString(Tariffario.getInstance().getCostoLitro(carburante.getSelectionModel().getSelectedItem())));
		costoRifornimento.setText(Double.toString(Tariffario.getInstance().getRifornimento(rifornimento.getSelectionModel().getSelectedItem())));
		moraCarburante.setText(Double.toString(entity.getMoraCarburante()));
		moraDurata.setText(Double.toString(entity.getMoraDurata()));
		moraChilometraggio.setText(Double.toString(entity.getMoraChilometraggio()));
	}

	@Override
	protected Tariffario buildEntity() {
		// TODO Auto-generated method stub
		return null;
	}		
}