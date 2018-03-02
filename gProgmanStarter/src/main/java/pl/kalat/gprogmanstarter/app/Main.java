package pl.kalat.gprogmanstarter.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.kalat.gprogmanstarter.controller.GProgmanStarterController;


/**
 *
 * @author Robert Kałat
 */
public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //create starter window
        FXMLLoader loaderStarter = new FXMLLoader();
        loaderStarter.setLocation(this.getClass().getResource("/fxml/gProgmanStarter.fxml"));
        
        //create starter info window
        FXMLLoader loaderStarterInfo = new FXMLLoader();
        loaderStarterInfo.setLocation(this.getClass().getResource("/fxml/gProgmanStarterInfo.fxml"));
        
        
        Pane paneStarter = loaderStarter.load();
        GProgmanStarterController controller = loaderStarter.getController();
        
        
        Scene scene = new Scene(paneStarter);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Progrman starter");
        primaryStage.show();

    }
}
