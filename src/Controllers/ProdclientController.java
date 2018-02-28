/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Produit;
import Services.PatisserieDAO;
import Services.Service_produit;
import Tools.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    Connection con=  DataSource.getInstance().getConnection();
   
    private Statement st;
    PreparedStatement pste;

    private ResultSet rs;
  Service_produit sv_p = new Service_produit();
 PatisserieDAO pc=new PatisserieDAO();
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher();
        ancr.setVisible(false);

    }

    @FXML
    public void selectprod(MouseEvent event) throws SQLException {
        ancr.setVisible(true);
        String path = prods
                .get(table.getSelectionModel().getSelectedIndex())
                .getImage();
        String imageURI = new File(path).toURI().toString();
        Image image = new Image(imageURI);
        imgP.setImage(image);

        txtinf.setText("      " + prods
                .get(table.getSelectionModel().getSelectedIndex()).getLibellé() + "\n"
                + "Description : " + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getDescription() + "\n"
                + "Prix :"
                + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getPrix() + "\n"
                + "Disponibilité :"
                + prods
                        .get(table.getSelectionModel().getSelectedIndex()).getDisponiblité()+ "\n"
          +"Patisserie : "+ pc.findById(prods.get(table.getSelectionModel().getSelectedIndex()).getId_patisserie()).getNom()
        );

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
                        prods.add(new Produit
        (rs.getInt("id_produit"),rs.getString("libellé"), rs.getString("description"),
                                rs.getFloat("prix"), rs.getString("disponiblité"), rs.getInt("id_patisserie"),
                                rs.getString("type_Produit"),rs.getString("image")));
                    }
                    table.setItems(prods);
                } catch (SQLException ex) {
                    Logger.getLogger(ListeprodController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
