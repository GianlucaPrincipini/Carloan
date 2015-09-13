package presentation.gui.controller;

import integration.DateHelper;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import business.entity.Agenzia;
import business.entity.Cliente;
import business.entity.Contratto;
import business.entity.Rifornimento;
import business.entity.Vettura;

public class SchermataContratto extends SchermataDati<Contratto>{
	
	@FXML
	private TextField acconto;
	
	@FXML
	private TextField chilometriPrevisti;
	
	@FXML
	private DatePicker dataInizioNoleggio;
	
	@FXML
	private DatePicker dataFineNoleggio;

	@FXML
	private DatePicker dataStipula;
	
	@FXML
	private Label operatore;
	
	@FXML
	private Label costo;
	
	@FXML
	private Label cliente;
	
	@FXML
	private Label vettura;
	
	@FXML
	private Label agenziaNoleggio;
	
	@FXML
	private Label agenziaConsegna;
	
	@FXML
	private CheckBox assicurazioneAvanzata;
	
	@FXML
	private CheckBox chilometraggioLimitato;
	
	@FXML
	private ChoiceBox<Rifornimento> rifornimento;
	

	@FXML
	public void onSelezioneVettura() {
		vettura.setText((String) controller.processRequest("MostraSelezione", "Vettura"));
	}
	
	@FXML
	public void onSelezioneAgenziaNoleggio() {
		agenziaNoleggio.setText((String) controller.processRequest("MostraSelezione", "Agenzia"));
	}
	
	@FXML
	public void onSelezioneCliente() {
		cliente.setText((String) controller.processRequest("MostraSelezione", "Cliente"));
	}
	
	
	@FXML
	public void onSelezioneAgenziaConsegna() {
		agenziaConsegna.setText((String) controller.processRequest("MostraSelezione", "Agenzia"));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		operatore.setText(CarloanFrontController.getInstance().getUserAuthenticated().getUsername());
		rifornimento.setItems(FXCollections.observableArrayList(Rifornimento.values()));
		chilometraggioLimitato.selectedProperty().set(true);
		chilometraggioLimitato.selectedProperty().addListener(new ChangeListener<Boolean>(){
		    @Override
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				chilometriPrevisti.setDisable(!newValue);
		    }
		});
	}

	
	@Override
	public void onConferma() {
		Contratto contratto = buildEntity();
		contratto.setCosto((Double) controller.processRequest("CalcolaCosto", contratto));
		if (contratto != null) {
			if (edit) controller.processRequest("ModificaContratto", buildEntity());
			else controller.processRequest("AggiungiContratto", buildEntity());
		} 
		close();
	}

	@FXML
	public void onCalcolaCosto() {
		costo.setText(Double.toString((Double) controller.processRequest("CalcolaCosto", buildEntity())));
	}
	
	@Override
	public void initModifica(Contratto entity) {
		edit = true;
		costo.setText(Double.toString(entity.getCosto()));
		acconto.setText(Double.toString(entity.getAcconto()));

		dataInizioNoleggio.setValue(java.time.LocalDate.of(entity.getDataInizioNoleggio().getYear(), entity.getDataInizioNoleggio().getMonthOfYear(), entity.getDataInizioNoleggio().getDayOfMonth()));
		dataFineNoleggio.setValue(java.time.LocalDate.of(entity.getDataFineNoleggio().getYear(), entity.getDataFineNoleggio().getMonthOfYear(), entity.getDataFineNoleggio().getDayOfMonth()));
		dataStipula.setValue(java.time.LocalDate.of(entity.getDataStipula().getYear(), entity.getDataStipula().getMonthOfYear(), entity.getDataStipula().getDayOfMonth()));

		
		agenziaNoleggio.setText(Integer.toString(entity.getAgenziaNoleggio().getId()));
		agenziaConsegna.setText(Integer.toString(entity.getAgenziaConsegna().getId()));

		
		chilometriPrevisti.setText(Integer.toString(entity.getChilometriPrevisti()));
		
		rifornimento.getSelectionModel().select(entity.getRifornimento());
		chilometraggioLimitato.selectedProperty().set(entity.isChilometraggioLimitato());
		assicurazioneAvanzata.selectedProperty().set(entity.isAssicurazioneAvanzata());		

		operatore.setText(entity.getOperatore().getUsername());
		vettura.setText(Integer.toString(entity.getId()));
		cliente.setText(entity.getCliente().getCodicePatente());
		
	}


	@Override
	protected Contratto buildEntity() {
		Contratto contratto = new Contratto();
		contratto.setAgenziaConsegna((Agenzia) controller.processRequest("ReadAgenzia", agenziaConsegna.getText()));
		contratto.setAgenziaNoleggio((Agenzia) controller.processRequest("ReadAgenzia", agenziaNoleggio.getText()));
		contratto.setCliente((Cliente) controller.processRequest("ReadCliente", cliente.getText()));
		contratto.setVettura((Vettura) controller.processRequest("ReadVettura", vettura.getText()));
		System.out.println(DateHelper.dateParse(dataFineNoleggio.getValue()));
		contratto.setDataFineNoleggio(DateHelper.dateParse(dataFineNoleggio.getValue()));
		contratto.setDataStipula(DateHelper.dateParse(dataStipula.getValue()));
		contratto.setDataInizioNoleggio(DateHelper.dateParse(dataInizioNoleggio.getValue()));
		contratto.setAcconto(Double.parseDouble(acconto.getText()));
		contratto.setRifornimento(rifornimento.getSelectionModel().getSelectedItem());
		contratto.setAssicurazioneAvanzata(assicurazioneAvanzata.selectedProperty().get());
		contratto.setChilometraggioLimitato(chilometraggioLimitato.selectedProperty().get());
		contratto.setChilometriPrevisti(Integer.parseInt(chilometriPrevisti.getText()));
		if (!costo.getText().equals("")) {
			return contratto;	
		}
		return null;
	}
	


}
