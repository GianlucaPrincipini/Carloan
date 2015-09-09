package presentation.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import presentation.gui.controller.table.TableContratti;
import presentation.gui.controller.table.TableController;
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
import javafx.scene.layout.Pane;

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
	
	@FXML
	private AnchorPane paneClienti;
	
	@FXML
	private AnchorPane paneModelli;
	
	@FXML
	private AnchorPane paneVetture;
	
	@FXML
	private AnchorPane paneFasce;
	
	@FXML
	private AnchorPane paneAgenzie;
	
	@FXML
	private AnchorPane paneOptionals;
	
	@FXML
	private AnchorPane paneOperatori;
	
	private TableController tableController;
	
	
	@FXML
	public void onAggiungi() {
		controller.processRequest("MostraAggiungi"+tabPane.getSelectionModel().getSelectedItem().getText());
	}
	
	@FXML
	public void onModifica() {
		System.out.println("we");
		controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText(), 
				controller.processRequest("Read"+tabPane.getSelectionModel().getSelectedItem().getText(), tableController.getPrimaryKey()));
	}
	
	@FXML
	public void onRimuovi() {
		controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText());
	}	

	private class TabChangeListener implements ChangeListener<Number> {

		TabChangeListener() {
			changed(null, 0, 0);
		}
		
		@Override
		public void changed(ObservableValue observable, Number oldValue,
				Number newValue) {
			FXMLLoader loadedTable = null;
			try {
				if ((Integer) newValue == 0){
					paneContratti.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableContratti.fxml"));
					paneContratti.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 1) {
					paneClienti.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableClienti.fxml"));
					paneClienti.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 2) {
					paneVetture.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableVetture.fxml"));
					paneVetture.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 3) {
					paneModelli.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableModelli.fxml"));
					paneModelli.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 4) {
					paneFasce.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableFasce.fxml"));
					paneFasce.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 5) {
					paneOptionals.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableOptionals.fxml"));
					paneOptionals.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 6) {
					paneAgenzie.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableAgenzie.fxml"));
					paneAgenzie.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 7) {
					paneOperatori.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tabelle/TableOperatori.fxml"));
					paneOperatori.getChildren().setAll(loadedTable.load());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			tableController = loadedTable.<TableController>getController();
		}

	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = CarloanFrontController.getInstance();
		tabPane.getSelectionModel().selectedIndexProperty().addListener(new TabChangeListener());
	}
	
}
