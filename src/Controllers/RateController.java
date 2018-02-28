/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * FXML Controller class
 *
 * @author jihed
 */
public class RateController implements Initializable {

    @FXML
    private Slider rateslide = new Slider();
    @FXML
    private Button btn_rate;
    @FXML
    private Label nbr;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    


    @FXML
    private void rate(ActionEvent event) {
        Double r = rateslide.getValue();
        nbr.setText(String.valueOf(r));
    }

    @FXML
    private void rate(ScrollEvent event) {
    }
    
}
