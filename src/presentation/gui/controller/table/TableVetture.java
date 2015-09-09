package presentation.gui.controller.table;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import business.entity.Vettura;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class TableVetture implements TableController{

	private FrontController controller;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private TableColumn<Vettura,String> targa;
	
	@FXML
	private TableColumn<Vettura,String> modello;
	
	@FXML
	private TableColumn<Vettura,String> agenziaLocalizzazione;
	
	@FXML
	private TableColumn<Vettura,String> chilometraggio;
	
	@FXML
	private TableColumn<Vettura,String> stato;
	
	@FXML
	private TableView<Vettura> tabVetture;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = new CarloanFrontController();
		
		ObservableList<Vettura> vetture = FXCollections.observableList((List<Vettura>) controller.processRequest("ReadAllVetture"));
		
        targa.setCellValueFactory(new Callback<CellDataFeatures<Vettura, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vettura, String> a) {
            	return new ReadOnlyObjectWrapper(a.getValue().getTarga());
     		}
        });	
        
        modello.setCellValueFactory(new Callback<CellDataFeatures<Vettura, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vettura, String> a) {
            	return new ReadOnlyObjectWrapper(a.getValue().getModello().getId());
     		}
        });
        
        agenziaLocalizzazione.setCellValueFactory(new Callback<CellDataFeatures<Vettura, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vettura, String> a) {
            	return new ReadOnlyObjectWrapper(a.getValue().getAgenziaLocalizzazione().getId());
     		}
        });
        
        chilometraggio.setCellValueFactory(new Callback<CellDataFeatures<Vettura, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vettura, String> a) {
            	return new ReadOnlyObjectWrapper(a.getValue().getChilometraggio());
     		}
        });
        
        stato.setCellValueFactory(new Callback<CellDataFeatures<Vettura, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vettura, String> a) {
            	return new ReadOnlyObjectWrapper(a.getValue().getStato());
     		}
        });
        
        tabVetture.setItems(vetture);
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
