/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Tools.config2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user16
 */
public class ComptCController implements Initializable {

    @FXML
    private AnchorPane paneData;
    @FXML
    private ListView<String> listMenu;
    Stage stage;
    config2 con = new config2();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listMenu.getItems().addAll(" Mes infos", "  Mes favoris", " Mes abpnements", "Mes commandes");
        listMenu.getSelectionModel().select(0);
        con.loadAnchorPane(paneData, "infoclient.fxml"); //pane
        listMenu.requestFocus();

    }

    @FXML
    private void aksiKlikListMenu(MouseEvent event) {

        switch (listMenu.getSelectionModel().getSelectedIndex()) {
            case 0: {
                con.loadAnchorPane(paneData, "infoclient.fxml");
            }
            break;

        }

    }
}
