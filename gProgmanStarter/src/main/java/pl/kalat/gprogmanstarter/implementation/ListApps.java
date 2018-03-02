package pl.kalat.gprogmanstarter.implementation;

/**
 *
 * @author Robert Kałat
 */
public enum ListApps {
    KADRY("kadry", "Kadry.exe", "Kadry.ini"),
    PLACE("place", "Place.exe", "Place.ini"),
    ZLECONE("zlecone", "Zlecone.exe", "Zlecone.ini"),
    PRZELEWY("przelewy", "Przelewy.exe", "Przelewy.ini");

    private final String appName;
    private final String appExe;
    private final String appConfig;

    private ListApps(String appName, String appExe, String appConfig) {
        this.appName = appName;
        this.appExe = appExe;
        this.appConfig = appConfig;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppExe() {
        return appExe;
    }

    public String getAppConfig() {
        return appConfig;
    }

    /**
     * Validates that app name (argument from main method) is on the enum list
     *
     * @param arg App name (argument from main method)
     * @return true if name is on the list
     */
    public static boolean checkAppName(String arg) {
        for (ListApps n : ListApps.values()) {
            if (n.getAppName().equals(arg.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get name of EXE file
     *
     * @param arg App name (argument from main method)
     * @return name of EXE file
     */
    public static String getNameExe(String arg) {
        String result = "";
        for (ListApps n : ListApps.values()) {
            if (n.getAppName().equals(arg.toLowerCase())) {
                result = n.getAppExe();
            }
        }
        return result;
    }

    /**
     * Get name of INI file
     *
     * @param arg App name (argument from main method)
     * @return name of INI file
     */
    public static String getNameConfig(String arg) {
        String result = "";
        for (ListApps n : ListApps.values()) {
            if (n.getAppName().equals(arg.toLowerCase())) {
                result = n.getAppConfig();
            }
        }
        return result;
    }

    /**
     *
     * @return name of EXE file
     */
    @Override
    public String toString() {
        return getAppExe();
    }
}