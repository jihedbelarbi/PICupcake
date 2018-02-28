///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import Entities.Reclamation;
//import Services.CRUD_Reclamation;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.function.Predicate;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//
///**
// * FXML Controller class
// *
// * @author jihed
// */
//public class ReclamationlisteController implements Initializable {
//
//    @FXML
//    private Label lab1;
//    @FXML
//    private SplitPane spp;
//    @FXML
//    private AnchorPane ap1;
//    @FXML
//    private Label lab2;
//    @FXML
//    private TextField txtc;
//    @FXML
//    private TableColumn<Reclamation, String> CC;
//    @FXML
//    private TableColumn<Reclamation, String> CP;
//    @FXML
//    private AnchorPane ap2;
//    @FXML
//    private GridPane gridC;
//    @FXML
//    private Label nomc;
//    @FXML
//    private Label nomp;
//    @FXML
//    private Label Datec;
//    @FXML
//    private Label reclamationc;
//    @FXML
//    private Label info;
//    @FXML
//    private TableView<Reclamation> TableReclamation;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//        try {
//            CC.setCellValueFactory((TableColumn.CellDataFeatures<Reclamation, String> Reclamations) -> new SimpleStringProperty(Reclamations.getValue().getClient().getNom()));
//            CP.setCellValueFactory((TableColumn.CellDataFeatures<Reclamation, String> Reclamations) -> new SimpleStringProperty(Reclamations.getValue().getPatisserie().getNom()));
//            CRUD_Reclamation CR = new CRUD_Reclamation();
//            ObservableList<Reclamation> Reclamations = FXCollections.observableArrayList((ArrayList<Reclamation>) CR.displayAllFeedBack());
//            TableReclamation.setItems(Reclamations);
//
//            FilteredList<Reclamation> listeFiltre = new FilteredList<>(Reclamations, e -> true);
//            txtc.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                listeFiltre.setPredicate((Predicate<? super Reclamation>) candidat -> {
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//                    String lowerCaseFilter = newValue.toLowerCase();
//                    if (candidat.getClient().getNom().contains(newValue)) {
//                        return true;
//                    }
//                    return false;
//                });
//                SortedList<Reclamation> CandidatTries = new SortedList<>(listeFiltre);
//                CandidatTries.comparatorProperty().bind(TableReclamation.comparatorProperty());
//                TableReclamation.setItems(CandidatTries);
//            });
//            TableReclamation.setOnMouseClicked(event -> {
//
//                nomc.setText(String.valueOf(Reclamations
//                        .get(TableReclamation.getSelectionModel().getSelectedIndex())
//                        .getClient().getNom()));
//
//                nomp.setText(String.valueOf(Reclamations
//                        .get(TableReclamation.getSelectionModel().getSelectedIndex())
//                        .getPatisserie().getNom()));
//
//                Datec.setText(Reclamations
//                        .get(TableReclamation.getSelectionModel().getSelectedIndex())
//                        .getDate());
//
//                reclamationc.setText(Reclamations
//                        .get(TableReclamation.getSelectionModel().getSelectedIndex())
//                        .getContent());
//
//            });
//        } catch (SQLException ex) {
//            Logger.getLogger(ReclamationlisteController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
