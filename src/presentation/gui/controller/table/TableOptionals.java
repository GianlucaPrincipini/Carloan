package presentation.gui.controller.table;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import business.entity.Optional;
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

public class TableOptionals implements TableController{

	private FrontController controller;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private TableColumn<Optional,String> id;
	
	@FXML
	private TableColumn<Optional,String> tipo;
	
	@FXML
	private TableColumn<Optional,String> costo;
	
	@FXML
	private TableView<Optional> tabOptional;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = new CarloanFrontController();
		
		ObservableList<Optional> optionals = FXCollections.observableList((List<Optional>) controller.processRequest("ReadAllOptionals"));
		
        id.setCellValueFactory(new Callback<CellDataFeatures<Optional, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Optional, String> o) {
            	return new ReadOnlyObjectWrapper(Integer.toString(o.getValue().getId()));
     		}
        });		
        
        tipo.setCellValueFactory(new Callback<CellDataFeatures<Optional, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Optional, String> o) {
            	return new ReadOnlyObjectWrapper(o.getValue().getTipo());
     		}
        });
        
        costo.setCellValueFactory(new Callback<CellDataFeatures<Optional, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Optional, String> o) {
            	return new ReadOnlyObjectWrapper(o.getValue().getCosto());
     		}
        });
        
        tabOptional.setItems(optionals);
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
