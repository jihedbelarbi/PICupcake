///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import Entities.Patisserie;
//import Entities.Suggestion;
//import Services.CRUD_Suggestion;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellDataFeatures;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//
///**
// * FXML Controller class
// *
// * @author jihed
// */
//public class FXMLControllerFXMLtest implements Initializable {
//
//    CRUD_Suggestion cruds = new CRUD_Suggestion();
//    private ListView<?> Affichage;
//    @FXML
//    private TableView<Suggestion> TableSuggestion;
//    @FXML
//    private TableColumn<Suggestion, String> CE;
//    @FXML
//    private TableColumn<Suggestion, String> CR;
//    @FXML
//    private TableColumn<Suggestion, String> CP;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//            CE.setCellValueFactory((CellDataFeatures<Suggestion,String>Suggestion)-> new SimpleStringProperty(Suggestion.getValue().getClient_emetteur().getNom()));
//            CR.setCellValueFactory((CellDataFeatures<Suggestion,String>Suggestion)-> new SimpleStringProperty(Suggestion.getValue().getClient_recepteur().getNom()));
//            CP.setCellValueFactory((CellDataFeatures<Suggestion,String>Suggestion)-> new SimpleStringProperty(Suggestion.getValue().getPatisserie().getNom()));
//            CRUD_Suggestion CS = new CRUD_Suggestion();
//        try {
//            System.out.println(CS.displaySuggestionP());
//            ObservableList<Suggestion> suggestions = FXCollections.observableArrayList((ArrayList<Suggestion>) CS.displaySuggestionP());
//            System.out.println(suggestions.size());
//            TableSuggestion.setItems(suggestions);
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLControllerFXMLtest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
