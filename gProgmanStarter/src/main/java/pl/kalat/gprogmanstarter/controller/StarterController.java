package pl.kalat.gprogmanstarter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import pl.kalat.gprogmanstarter.implementation.ArrayItem;
import pl.kalat.gprogmanstarter.implementation.ListApps;

/**
 * FXML Controller class
 *
 * @author Robert Kałat
 */
public class StarterController {

    private String[][] arrayItem = null;
    private String appName = "";
    private String appExe = "";
    private String appConfig = "";
    @FXML
    private Hyperlink urlLink;
    @FXML
    private ChoiceBox<String> appList;

    /**
     * Close the program
     * @param event 
     */
    @FXML
    void onActionButtonEnd(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Prepare config and run program with correct db
     * @param event 
     */
    @FXML
    void onActionButtonStart(ActionEvent event) {
        System.out.println("Do zaimplementowania: uruchamiam program");
        /*
        //prepare Config 
        String companySelected = jComboBoxDB.getSelectedItem().toString();
        String appConfigSelected = "";
        int i = 0;
        while (i < arrayItem.length) {
            if (arrayItem[i][0].equals(companySelected)) {
                appConfigSelected = arrayItem[i][1];
            }
            i++;
        }

        try {
            PathConfigFile.configFileCopy(appName, appConfig, appConfigSelected);
        } catch (IOException ex) {
            Logger.getLogger(gProgmanStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
         //Run application
         
        Runtime r = Runtime.getRuntime();
        try {
            r.exec(appExe);
        } catch (IOException ex) {
            Logger.getLogger(gProgmanStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    /**
     * Open URL in web browser
     * @param event
     * @throws IOException 
     */
    @FXML
    void onActionUrlWK(ActionEvent event) throws IOException {
        new ProcessBuilder("x-www-browser", urlLink.getText()).start();
    }

    /**
     * prepare choiceBox list
     */
    @FXML
    void initialize() {

        arrayItem = ArrayItem.prepareArrayItem("gProgmanStarter.config.ini");

        //new ArrayList<>(Arrays.asList(array))
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //for (int i = 0; i < arrayItem.length; i++) {
        appList.setItems(FXCollections.observableArrayList(list));
        //jComboBoxDB.addItem(arrayItem[i][0]);
        //}
    }

    /**
     * set all variable names of chosen program
     * @param appName 
     */
    public void setAppNames(String appName) {
        this.appName = appName.toLowerCase();
        this.appExe = ListApps.getNameExe(appName);
        this.appConfig = ListApps.getNameConfig(appName);
    }

}
