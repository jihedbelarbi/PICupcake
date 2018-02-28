///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import Entities.FeedBack;
//import Services.CRUD_FeedBack;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.ResourceBundle;
//import java.util.function.Predicate;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.TextFlow;
//
///**
// * FXML Controller class
// *
// * @author jihed
// */
//public class FeedbacklisteController implements Initializable {
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
//    private TableColumn<FeedBack, String> CC;
//    @FXML
//    private AnchorPane ap2;
//    @FXML
//    private Label info;
//    @FXML
//    private TableView<FeedBack> Tablefeedback;
//    @FXML
//    private TableColumn<FeedBack, String> CD;
//    @FXML
//    private TextField zonedesc;
//    @FXML
//    private TableColumn<FeedBack, Date> CDate;
//    CRUD_FeedBack CF = new CRUD_FeedBack();
//    @FXML
//    private Button Ajouter;
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            CC.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, String> FeedBacks) -> new SimpleStringProperty(FeedBacks.getValue().getClient().getNom()));
//            CD.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, String> FeedBacks) -> new SimpleStringProperty(FeedBacks.getValue().getDescription()));
//            
//            ObservableList<FeedBack> FeedBacks = FXCollections.observableArrayList((ArrayList<FeedBack>) CF.displayAllFeedBackP(1));
//            Tablefeedback.setItems(FeedBacks);
//
//            FilteredList<FeedBack> listeFiltre = new FilteredList<>(FeedBacks, e -> true);
//            txtc.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                listeFiltre.setPredicate((Predicate<? super FeedBack>) candidat -> {
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//                    String lowerCaseFilter = newValue.toLowerCase();
//                    if (candidat.getPatisserie().getNom().contains(newValue)) {
//                        return true;
//                    }
//                    return false;
//                });
//                SortedList<FeedBack> CandidatTries = new SortedList<>(listeFiltre);
//                CandidatTries.comparatorProperty().bind(Tablefeedback.comparatorProperty());
//                Tablefeedback.setItems(CandidatTries);
//            });
//            Tablefeedback.setOnMouseClicked(event -> {
//
//                zonedesc.setText(String.valueOf(FeedBacks
//                        .get(Tablefeedback.getSelectionModel().getSelectedIndex())
//                        .getDescription()));
//
//            });
//
//        } catch (SQLException ex) {
//            Logger.getLogger(SuggestionlisteController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }    
//
//    private void supp(ActionEvent event) throws SQLException {
//        CF.deleteFeedBackP(1);
//    }
//
//    @FXML
//    private void Ajouter(ActionEvent event) {
//    }
//    
//}
