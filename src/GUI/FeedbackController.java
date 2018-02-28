///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import Entities.FeedBack;
//import Services.CRUD_FeedBack;
//import static cupcake.Test_Jihed.client;
//import static cupcake.Test_Jihed.patisserie;
//import java.net.URL;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import static java.time.zone.ZoneRulesProvider.refresh;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextArea;
//import org.controlsfx.control.NotificationPane;
//
///**
// * FXML Controller class
// *
// * @author jihed
// */
//public class FeedbackController implements Initializable {
//
//    @FXML
//    private TextArea id_comment;
//    @FXML
//    private Button btn_ajout;
//    String msg;
//    private ListView listcomment;
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
////        try {
////            CRUD_FeedBack cf=new CRUD_FeedBack();
////            FeedBack f = new FeedBack();
////            cf.displayAllFeedBackP(f.getPatisserie().getID());
////            
////            for (int i=0;i<cf.displayAllFeedBackP(f.getPatisserie().getID()).size();i++){
////                msg=(cf.displayAllFeedBackP(f.getClient().getId()).get(i))+"   "+(cf.displayAllFeedBackP(f.getPatisserie().getID()).get(i).getDescription());
////                listcomment.getItems().add(i, msg);
////                
////            }
////        } catch (SQLException ex) {
////            Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }    
//
//    @FXML
//    private void Ajouter_Comment(ActionEvent event) throws SQLException {
////        if(id_comment.getText().isEmpty()){
////             NotificationPane.create().title("Attention").text("Vous devez ecrire un commentaire ").showWarning();
////
////        }else {
////            CRUD_FeedBack cf=new CRUD_FeedBack();
////                FeedBack f=new FeedBack(LocalDateTime.MAX,patisserie.getID(), client.getId(), msg);
////                cf.insertFeedBackP(f);
////                refresh();
////        }
//        
////        CRUD_FeedBack cf = new CRUD_FeedBack();
////        FeedBack f = new FeedBack(1, 1, id_comment.getText(), LocalDateTime.MAX);
////        cf.insertFeedBackP(f);
////        refresh();
//    }
//    
//}
