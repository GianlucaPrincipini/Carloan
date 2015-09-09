package presentation.gui.controller.table;

import presentation.frontcontroller.FrontController;
import business.entity.Contratto;
import business.entity.Fascia;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class TableFasce {

	private FrontController controller;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private TableColumn<Contratto,String> id;
	
	@FXML
	private TableView<Fascia> tabFasce;
	
}
