package presentation.gui.controller;

import integration.DateHelper;

import java.net.URL;
import java.util.ResourceBundle;

import org.joda.time.LocalDate;

import business.entity.Cliente;
import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import presentation.gui.CarloanStage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SchermataCliente extends SchermataDati<Cliente>{

	private FrontController controller;
	
	@FXML
	private Node root;
	
	@FXML
	private Button conferma;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField cognome;
	
	@FXML
	private TextField codicePatente;
	
	@FXML
	private TextField telefono;
	
	@FXML
	private TextField email;
	
	@FXML
	private DatePicker dataDiNascita;
	
	
	
	@FXML
	public void onConferma() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome.getText());
		cliente.setCognome(cognome.getText());
		cliente.setEMail(email.getText());
		cliente.setNumTelefono(telefono.getText());
		cliente.setCodicePatente(codicePatente.getText());
		java.time.LocalDate datanascita = dataDiNascita.getValue();
		cliente.setDataNascita(new LocalDate(datanascita.getYear(), datanascita.getMonthValue(), datanascita.getDayOfMonth()));
		if (!edit)
			controller.processRequest("AggiungiCliente", cliente);
		else {
			controller.processRequest("ModificaCliente", cliente);
			edit = false;
		}
		close();
	}
	
	
	public void initModifica(Cliente cliente) {
		edit = true;
		nome.setText(cliente.getNome());
		cognome.setText(cliente.getCognome());
		email.setText(cliente.getEMail());
		telefono.setText(cliente.getNumTelefono());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = CarloanFrontController.getInstance();
	}


}
