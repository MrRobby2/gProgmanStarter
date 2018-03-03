package pl.kalat.gprogmanstarter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Robert Kałat
 */
public class InfoController {
    
    @FXML
    private Label starterInfoLabel;
    
    @FXML
    void initialize() {
        starterInfoLabel.setText("Brak poprawnego parametru wywołania programu");
    }    
    
}
