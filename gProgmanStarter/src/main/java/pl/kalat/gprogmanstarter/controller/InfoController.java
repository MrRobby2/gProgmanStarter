package pl.kalat.gprogmanstarter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.kalat.gprogmanstarter.implementation.ListApps;

/**
 * FXML Controller class
 *
 * @author Robert Kałat
 */
public class InfoController {

    @FXML
    private Label starterInfoLabel;
    @FXML
    private Label starterInfoLabel2;
    @FXML
    private Label starterInfoLabel3;

    @FXML
    void initialize() {
        starterInfoLabel.setText("Brak poprawnego parametru wywołania programu");
        starterInfoLabel2.setText("Dozwolone parametry:");
        String s = "";
        for (ListApps n : ListApps.values()) {
            s += n.getAppName() + " ";
        }
        starterInfoLabel3.setText(s);
    }

}
