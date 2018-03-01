/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Suggestion;
import Services.CRUD_Suggestion;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author jihed
 */
public class SuggestionlisteController implements Initializable {

    @FXML
    private Label lab1;
    @FXML
    private SplitPane spp;
    @FXML
    private AnchorPane ap1;
    private TextField txtc;
    @FXML
    private TableColumn<Suggestion, String> CC;
    @FXML
    private TableColumn<Suggestion, String> CP;
    @FXML
    private AnchorPane ap2;
    @FXML
    private GridPane gridC;
    @FXML
    private Label info;
    @FXML
    private Label info1;
    @FXML
    private GridPane gridC1;
    @FXML
    private TableView<Suggestion> TableSuggestion;
    @FXML
    private Label nomc;
    @FXML
    private Label prenomc;
    @FXML
    private Label emailc;
    @FXML
    private Label adressec;
    @FXML
    private Label nomp;
    @FXML
    private Label Descp;
    @FXML
    private Label emailp;
    @FXML
    private Label adressp;
    @FXML
    private Button Acceder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CC.setCellValueFactory((TableColumn.CellDataFeatures<Suggestion, String> Suggestion) -> new SimpleStringProperty(Suggestion.getValue().getClient_emetteur().getNom()));
            CP.setCellValueFactory((TableColumn.CellDataFeatures<Suggestion, String> Suggestion) -> new SimpleStringProperty(Suggestion.getValue().getPatisserie().getNom()));
            CRUD_Suggestion CS = new CRUD_Suggestion();
            ObservableList<Suggestion> suggestions = FXCollections.observableArrayList((ArrayList<Suggestion>) CS.displaySuggestionP());
            TableSuggestion.setItems(suggestions);
//
//            FilteredList<Suggestion> listeFiltre = new FilteredList<>(suggestions, e -> true);
//            txtc.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                listeFiltre.setPredicate((Predicate<? super Suggestion>) candidat -> {
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//                    String lowerCaseFilter = newValue.toLowerCase();
//                    if (candidat.getClient_recepteur().getNom().contains(newValue)) {
//                        return true;
//                    }
//                    return false;
//                });
//                SortedList<Suggestion> CandidatTries = new SortedList<>(listeFiltre);
//                CandidatTries.comparatorProperty().bind(TableSuggestion.comparatorProperty());
//                TableSuggestion.setItems(CandidatTries);
//            });
TableSuggestion.setOnMouseClicked(event -> {
    
    nomc.setText(String.valueOf(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getClient_emetteur().getNom()));
    
    prenomc.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getClient_emetteur().getPrenom());
    
    emailc.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getClient_emetteur().getMail());
    
    adressec.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getClient_emetteur().getAddress());
    
    nomp.setText(String.valueOf(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getPatisserie().getNom()));
    
    Descp.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getPatisserie().getEmail());
    
    emailp.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getPatisserie().getEmail());
    
    adressp.setText(suggestions
            .get(TableSuggestion.getSelectionModel().getSelectedIndex())
            .getPatisserie().getEmail());
});
        } catch (SQLException ex) {
            Logger.getLogger(SuggestionlisteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Acceder(ActionEvent event) {
        
    }
}
