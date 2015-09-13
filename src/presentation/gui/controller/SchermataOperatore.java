package presentation.gui.controller;

import integration.DateHelper;
import integration.Encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.entity.Agenzia;
import business.entity.Amministratore;
import business.entity.Operatore;

public class SchermataOperatore extends SchermataDati<Operatore>{

	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField cognome;
	
	@FXML
	private TextField telefono;
	
	@FXML
	private TextField email;
	
	@FXML
	private DatePicker dataDiNascita;
	
	@FXML
	private Label agenzia;
	
	@FXML
	private CheckBox amministratore;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	public void onConferma() {
		if (edit) {
			controller.processRequest("ModificaOperatore", buildEntity());
		} else {
			controller.processRequest("AggiungiOperatore", buildEntity());
		}
		close();
	}

	@Override
	public void initModifica(Operatore entity) {
		edit = true;
		id = entity.getId();
		username.setText(entity.getUsername());
		password.setText(entity.getPassword());
		System.out.println(entity.getAgenzia());
		agenzia.setText(Integer.toString(entity.getAgenzia().getId()));
		nome.setText(entity.getNome());
		cognome.setText(entity.getCognome());
		email.setText(entity.getEMail());
		telefono.setText(entity.getNumTelefono());
		dataDiNascita.setValue(java.time.LocalDate.of(entity.getDataNascita().getYear(), entity.getDataNascita().getMonthOfYear(), entity.getDataNascita().getDayOfMonth()));
		amministratore.selectedProperty().set(entity instanceof Amministratore);
	}

	@Override
	protected Operatore buildEntity() {
		Operatore operatore;
		if (amministratore.selectedProperty().get()) {
			operatore = new Amministratore();
		} else {
			operatore = new Operatore();
		}
		operatore.setAgenzia((Agenzia)controller.processRequest("ReadAgenzia", agenzia.getText()));
		operatore.setUsername(username.getText());
		operatore.setId(id);
		try {
			operatore.setPassword(Encrypt.getEncryptedString(password.getText()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		operatore.setNome(nome.getText());
		operatore.setCognome(cognome.getText());
		operatore.setDataNascita(DateHelper.dateParse(dataDiNascita.getValue()));
		operatore.setEMail(email.getText());
		operatore.setNumTelefono(telefono.getText());
		return operatore;
	}

}
