/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginController.usernid;
import Entities.FeedBack;
import Entities.Produit;
import Entities.favoris;
import Services.CRUD_FeedBack;
import Services.PatisserieDAO;
import Services.Service_produit;
import Services.service_favoris;
import Tools.DataSource;
import Tools.config2;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Donia Khiari
 */
public class ProdclientController implements Initializable {

    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, String> col;
    @FXML
    private AnchorPane ancr;
    @FXML
    private ImageView imgP;
    @FXML
    private TextArea txtinf;
    private ObservableList<Produit> prods = FXCollections.observableArrayList();
    @FXML
    private TextField search;
    Connection con = DataSource.getInstance().getConnection();
    
    
    private Statement st;
    PreparedStatement pste;
    static int idprod;

    private ResultSet rs;
    Service_produit sv_p = new Service_produit();
    PatisserieDAO pc = new PatisserieDAO();

    @FXML
    private TableView<FeedBack> feedback;
    @FXML
    private TableColumn<FeedBack, String> Client;
    @FXML
    private TableColumn<FeedBack, String> description;
    @FXML
    private TableColumn<FeedBack, String> date;
    @FXML
    private TableColumn<FeedBack, Integer> id_feedback;
    @FXML
    private TextArea id_comment;
    @FXML
    private Button btn_ajout;
  String dat;
    @FXML
    private Button fav;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        dat=dateFormat.format(date);
        
        afficher();
        ancr.setVisible(false);
        

    }

    @FXML
    public void selectprod(MouseEvent event) throws SQLException, IOException {
        ancr.setVisible(true);
        String path = prods
                .get(table.getSelectionModel().getSelectedIndex())
                .getImage();
        String imageURI = new File(path).toURI().toString();
        Image image = new Image(imageURI);
        imgP.setImage(image);

        idprod = prods.get(table.getSelectionModel().getSelectedIndex()).getId_produit();
        Afficher_Comment(idprod);

        txtinf.setText("      " + prods
                .get(table.getSelectionModel().getSelectedIndex()).getLibellé() + "\n"
                + "Description : " + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getDescription() + "\n"
                + "Prix :"
                + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getPrix() + "\n"
                + "Disponibilité :"
                + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getDisponiblité() + "\n"
                + "Patisserie : " + pc.findById(prods.get(table.getSelectionModel().getSelectedIndex()).getId_patisserie()).getNom()
        );
       service_favoris sf = new service_favoris();
        fav.setOnAction(event1 -> {
           favoris f = new favoris(usernid,idprod);
            try { 
                sf.insertfavoris(f);
            } catch (SQLException ex) {
                Logger.getLogger(ProdclientController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        } );

    }

    public void afficher() {
        prods.clear();

        try {
            for (Produit p : sv_p.displayAll()) {
                System.out.println(p);
                prods.add(p);
                System.out.println("testtestets" + prods);
            }
            table.setItems(prods);
            col.setCellValueFactory(cell -> cell.getValue().getLibelleProperty());
        } catch (SQLException ex) {
            Logger.getLogger(ProdclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void search() {

        search.setOnKeyPressed(e -> {
            if ((search.getText().equals(""))) {
                afficher();

            } else {
                prods.clear();
                String sql = "select * from produit where libellé like '%" + search.getText() + "%'";
                try {
                    pste = con.prepareStatement(sql);
                    rs = pste.executeQuery();
                    while (rs.next()) {
                        prods.add(new Produit(rs.getInt("id_produit"), rs.getString("libellé"), rs.getString("description"),
                                rs.getFloat("prix"), rs.getString("disponiblité"), rs.getInt("id_patisserie"),
                                rs.getString("type_Produit"), rs.getString("image")));
                    }
                    table.setItems(prods);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeprodController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void Modifier_Comment(MouseEvent event) throws SQLException {
        FeedBack modifier = new FeedBack();
        CRUD_FeedBack f = new CRUD_FeedBack();
        modifier.setDescription(feedback.getSelectionModel().getSelectedItem().getDescription());
        TablePosition pos = feedback.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        if (pos.getColumn() == 0) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning Dialog");
//            alert.setHeaderText("Erreur");
//            alert.setContentText("Une erreur est survenu lors de la modification");
//            alert.showAndWait();
        }
        if (pos.getColumn() == 1) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning Dialog");
//            alert.setHeaderText("Erreur");
//            alert.setContentText("Une erreur est survenu lors de la modification");
//            alert.showAndWait();
        }
        // Item here is the table view type:
        FeedBack item = feedback.getItems().get(row);
        TableColumn col = pos.getTableColumn();

        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();
//        TextInputDialog dialog = new TextInputDialog(data);
//        dialog.setTitle("Modifier");
//        dialog.setHeaderText("Fenetre de modification");
//        dialog.setContentText("Modifier la cellule:");
//        int Colo = pos.getColumn();
//        Optional<String> result = dialog.showAndWait();
//        if (result.isPresent()){
//            if (Colo == 2) {
//                modifier.setId_feedback(item.getId_feedback());
//                modifier.setDescription(result.get());
//                f.updateFeedBackP(modifier);
//                System.out.println(modifier);
//            }
//        }
        Afficher_Comment(idprod);
        
    }

    @FXML
    private void Ajouter_Comment(ActionEvent event) throws SQLException {
         CRUD_FeedBack cf = new CRUD_FeedBack();
        FeedBack f = new FeedBack(usernid, idprod, id_comment.getText(), dat);
        cf.insertFeedBackProd(f);
        refresh();
        System.out.println("**********************************");
        System.out.println(idprod);
        System.out.println("**********************************");
        Afficher_Comment(idprod);
        
    }

    
    private void Afficher_Comment(int id) {

        try {
            //Client.setCellValueFactory(new PropertyValueFactory<>("id_client"));

            Client.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, String> FeedBack) -> new SimpleStringProperty(FeedBack.getValue().getClient().getNom()));
            date.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, String> FeedBack) -> new SimpleStringProperty(FeedBack.getValue().getDate()));
            description.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, String> FeedBack) -> new SimpleStringProperty(FeedBack.getValue().getDescription()));
            id_feedback.setCellValueFactory((TableColumn.CellDataFeatures<FeedBack, Integer> FeedBack) -> new SimpleIntegerProperty(FeedBack.getValue().getId_feedback()).asObject());
           
            CRUD_FeedBack cf = new CRUD_FeedBack();
            ObservableList<FeedBack> FeedBacks = FXCollections.observableArrayList((ArrayList<FeedBack>) cf.displayAllFeedBackProd(id));
            feedback.setItems(FeedBacks);
            System.out.println("**********************************");
            System.out.println(id);
            System.out.println("**********************************");
        } catch (SQLException ex) {
            Logger.getLogger(ListefeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void favadd(ActionEvent event) {
        
        
        
    }


}
