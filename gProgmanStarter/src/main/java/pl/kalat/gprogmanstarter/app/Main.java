package pl.kalat.gprogmanstarter.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.kalat.gprogmanstarter.controller.StarterController;
import pl.kalat.gprogmanstarter.controller.InfoController;
import pl.kalat.gprogmanstarter.implementation.ListApps;

/**
 *
 * @author Robert Kałat
 */
public class Main extends Application {

    private static String[] arguments;

    public static void main(String[] args) {
        arguments = args;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //create starter window
        FXMLLoader loaderStarter = new FXMLLoader();
        loaderStarter.setLocation(this.getClass().getResource("/fxml/Starter.fxml"));

        //create starter info window
        FXMLLoader loaderInfo = new FXMLLoader();
        loaderInfo.setLocation(this.getClass().getResource("/fxml/Info.fxml"));

        Scene scene = null;
        if (arguments.length == 0 || !ListApps.checkAppName(arguments[0])) {
            Pane paneInfo = loaderInfo.load();
            InfoController controller = loaderInfo.getController();
            scene = new Scene(paneInfo);
        } else {
            Pane paneStarter = loaderStarter.load();
            StarterController controller = loaderStarter.getController();
            controller.setAppNames(arguments[0]);
            scene = new Scene(paneStarter);
        }
 
        primaryStage.setScene(scene);
        primaryStage.setOpacity(0.95);
        primaryStage.setTitle("Progrman starter");
        primaryStage.show();

    }
}
