package presentation.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business.entity.IncidenzaFascia;
import business.entity.Tariffario;
import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import presentation.gui.controller.table.TableController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	private MenuItem disconnetti;
	
	@FXML 
	private MenuItem chiudiFinestra;
	
	@FXML
	private Button aggiungi;
	
	@FXML
	private Button modifica;
	
	@FXML
	private Button rimuovi;
	
	@FXML
	private Button chiudi;
	
	@FXML
	private Button refresh;
	
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
		controller.processRequest("Mostra"+tabPane.getSelectionModel().getSelectedItem().getText());
	}
	
	@FXML
	public void onModifica() {
		controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText(), 
				controller.processRequest("Read"+tabPane.getSelectionModel().getSelectedItem().getText(), tableController.getPrimaryKey()));
	}
	
	@FXML
	public void onRimuovi() {
		
		//controller.processRequest("MostraModifica"+tabPane.getSelectionModel().getSelectedItem().getText());
	}	
	
	@FXML
	public void onRefresh(){
		tabPane.getSelectionModel().select(tabPane.getSelectionModel().getSelectedIndex());
	}
	
	@FXML
	public void chiudiFinestra(){
		((Stage)root.getScene().getWindow()).close();
	}
	
	@FXML
	public void disconnessione(){
		chiudiFinestra();
		controller.processRequest("MostraLogin");
	}
	
	@FXML 
	public void modificaTariffario(){
		controller.processRequest("MostraModificaTariffario", Tariffario.getInstance());
	}
	
	@FXML
	public void modificaIncidenza(){
		controller.processRequest("MostraModificaIncidenzaFascia", IncidenzaFascia.getInstance());
	}
	
	private class TabChangeListener implements ChangeListener<Number> {

		TabChangeListener() {
			changed(null, 0, 0);
		}
		
		@SuppressWarnings("rawtypes")
		@Override
		public void changed(ObservableValue observable, Number oldValue, Number newValue) {
			FXMLLoader loadedTable = null;
			try {
				if ((Integer) newValue == 0){
					paneContratti.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableContratto.fxml"));
					paneContratti.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 1) {
					paneClienti.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableCliente.fxml"));
					paneClienti.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 2) {
					paneVetture.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableVettura.fxml"));
					paneVetture.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 3) {
					paneModelli.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableModello.fxml"));
					paneModelli.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 4) {
					paneFasce.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableFascia.fxml"));
					paneFasce.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 5) {
					paneOptionals.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableOptional.fxml"));
					paneOptionals.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 6) {
					paneAgenzie.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableAgenzia.fxml"));
					paneAgenzie.getChildren().setAll(loadedTable.load());
				} else if ((Integer) newValue == 7) {
					paneOperatori.getChildren().clear();
					loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableOperatore.fxml"));
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
