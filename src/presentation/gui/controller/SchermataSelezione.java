package presentation.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import presentation.gui.CarloanSelezione;
import presentation.gui.controller.table.TableController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SchermataSelezione implements Initializable {
	
	@FXML
	private Node root;
	
	@FXML
	private AnchorPane paneTabella;
	
	private TableController tableController;
	
	public void loadTable(String selezione) {
		paneTabella.getChildren().clear();
		try {
			FXMLLoader loadedTable = new FXMLLoader(Class.class.getResource("/presentation/gui/view/tables/TableModello.fxml"));
			paneTabella.getChildren().addAll(loadedTable.load());
			tableController = loadedTable.<TableController>getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	public void onConferma() {
		((CarloanSelezione)root.getScene().getWindow()).setValue(tableController.getPrimaryKey());
		close();
	}
	
	private void close() {
		((Stage)(root).getScene().getWindow()).close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
