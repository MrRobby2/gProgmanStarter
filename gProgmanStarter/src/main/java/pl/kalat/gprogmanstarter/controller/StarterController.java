package pl.kalat.gprogmanstarter.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import pl.kalat.gprogmanstarter.implementation.ArrayItem;
import pl.kalat.gprogmanstarter.implementation.ListApps;
import pl.kalat.gprogmanstarter.implementation.PathConfigFile;

/**
 * FXML Controller class
 *
 * @author Robert Kałat
 */
public class StarterController {

    private final String configFile = "gProgmanStarter.config.ini";
    private String[][] arrayItemList = null;
    private String appName = "";
    private String appExe = "";
    private String appConfig = "";
    private String appDirectoryConfig = "";
    @FXML
    private ChoiceBox<String> appList;

    /**
     * Close the program
     *
     * @param event
     */
    @FXML
    void onActionButtonEnd(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Prepare config and run program with correct db
     *
     * @param event
     */
    @FXML
    void onActionButtonStart(ActionEvent event) {
        
        //searching selected config
        String companySelected = (String) appList.getValue();
        String appConfigSelected = "";
        int i = 0;
        while (i < arrayItemList.length) {
            if (arrayItemList[i][0].equals(companySelected)) {
                appConfigSelected = arrayItemList[i][1];
            }
            i++;
        }

        //copy selected config file
        try {
            PathConfigFile.configFileCopy(appName, appConfig, appConfigSelected);
        } catch (IOException ex) {
            Logger.getLogger(StarterController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //run application
        Runtime r = Runtime.getRuntime();
        try {
            r.exec(appExe);
        } catch (IOException ex) {
            Logger.getLogger(StarterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * prepare choiceBox list
     */
    @FXML
    void initialize() {
        ArrayItem arrayItem = new ArrayItem(configFile);
        arrayItemList = arrayItem.getArrayFileLine();
        for (String[] a : arrayItemList) {
            appList.getItems().add(a[0]);
        }
        appList.setValue(arrayItemList[0][0]);
    }

    /**
     * set all variable names of chosen program
     *
     * @param appName
     */
    public void setAppNames(String appName) {
        this.appName = appName.toLowerCase();
        this.appExe = ListApps.getNameExe(appName);
        this.appConfig = ListApps.getNameConfig(appName);
        this.appDirectoryConfig = ListApps.getDirectoryConfig(appName);
    }
}