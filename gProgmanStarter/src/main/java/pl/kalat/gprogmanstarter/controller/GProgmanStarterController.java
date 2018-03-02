package pl.kalat.gprogmanstarter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Robert Kałat
 */
public class GProgmanStarterController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void onActionButtonEnd(ActionEvent event) {
        System.exit(0);
    }

      @FXML
    void onActionButtonStart(ActionEvent event) {
          System.out.println("Do zaimplementowania: uruchamiam program");
    }
    
      @FXML
    void onActionUrlWK(ActionEvent event) {
          System.out.println("Do zaimplementowania: otwarcie adresu w przegladarce");
    }
    
    @FXML
    void initialize() {

    }  
}
