package presentation.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import presentation.gui.controller.table.TableContratti;
import business.entity.Cliente;
import business.entity.Contratto;
import business.entity.Entity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainStage implements Initializable {
	
	private FrontController controller;
	
	@FXML
	private Node root;
	
	@FXML
	private MenuItem modTariffario;
	
	@FXML
	private MenuItem modIncidenza;
	
	@FXML 
	private MenuItem modCarburante;
	
	@FXML
	private Button aggiungi;
	
	@FXML
	private Button modifica;
	
	@FXML
	private Button rimuovi;
	
	@FXML
	private Button chiudi;
	
	@FXML 
	private TabPane tabPane;

	@FXML
	private AnchorPane paneContratti;
	
	private TableController tableController;
	
	@FXML
	public void onAggiungi() {
		controller.processRequest("MostraAggiungi"+tabPane.getSelectionModel().getSelectedItem().getText());
	}
	
	@FXML
	public void onModifica() {
		controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText());
	}
	
	@FXML
	public void onRimuovi() {
		controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText());
	}	

	private class TabChangeListener implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue observable, Number oldValue,
				Number newValue) {
			FXMLLoader loadedTable = new FXMLLoader();
			if ((Integer) newValue == 0){
				try {
					paneContratti.getChildren().setAll(loadedTable.load(Class.class.getResource("/presentation/gui/view/tabelle/TableContratti.fxml")));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if ((Integer) newValue == 1) {
				List<Cliente> clienti = (List<Cliente>) controller.processRequest("ReadAllClienti");
				System.out.println(clienti);
				ObservableList<Cliente> obsClienti = FXCollections.observableList(clienti);
				//tabClienti.setItems(obsClienti);
			}
			tableController = (TableController) loadedTable.getController();
		}

	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = CarloanFrontController.getInstance();
		tabPane.getSelectionModel().selectedIndexProperty().addListener(new TabChangeListener());
	}
	
}
