package pl.kalat.gprogmanstarter.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Robert Kałat
 */
public class PathConfigFile {

    /**
     * Copy config file from selected app to progman directory in user
     * directory.
     *
     * @param appName application name
     * @param appConfig config file name
     * @param selectedDB selected option in jbox
     * @throws IOException
     */
    public static void configFileCopy(String appName, String appConfig, String selectedDB) throws IOException {
        // get pathname from %apptdata%
        String appdata = System.getenv("APPDATA");
        // config file from selected app
        Path source = Paths.get("db.configs\\" + selectedDB);

        // pathname to progman directory in user directory.
        Path destination;
        if (appName.equals("biblioteka")) {
            destination = Paths.get(appConfig);
        } else {
            destination = Paths.get(appdata + "\\progman\\" + ListApps.getDirectoryConfig(appName) + "\\" + appConfig);
        }
        
        // copy config file from selected app to progman directory in user directory.      
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
