package pl.kalat.gprogmanstarter;

import pl.kalat.gprogmanstarter.implementation.ListApps;
import pl.kalat.gprogmanstarter.gui.gProgmanStarter;
import pl.kalat.gprogmanstarter.gui.gProgmanInfo;

/**
 *
 * @author Robert Kałat
 */
public class Main {

    public static void main(String[] args) {
        
        if (args.length == 0 || !ListApps.checkAppName(args[0])) {
            String msg = "Brak poprawnego parametru wywołania programu";
            new gProgmanInfo(msg).setVisible(true);
        } else {
            new gProgmanStarter(args[0]).setVisible(true);
        }

    }

}
