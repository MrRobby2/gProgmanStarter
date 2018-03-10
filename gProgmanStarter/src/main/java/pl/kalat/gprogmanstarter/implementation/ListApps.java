package pl.kalat.gprogmanstarter.implementation;

/**
 *
 * @author Robert Kałat
 */
public enum ListApps {
    KADRY("kadry", "Kadry.exe", "Kadry.ini", "kadry"),
    PLACE("place", "Place.exe", "Place.ini", "place"),
    ZLECONE("zlecone", "Zlecone.exe", "Zlecone.ini", "zlecone"),
    FINANSE("finanse", "Finanse.exe", "Finanse.ini", "finanse"),
    ROZRACHUNKI("rozrachunki", "Rozrachunki.exe", "Rozrachunki.ini", "rozrachunki"),
    KASA("kasa", "Kasa.exe", "Kasa.ini", "kasa ddj"),
    MAGAZYN("magazyn", "Magazyn.exe", "Magazyn.ini", "magazyn"),
    FUNDUSZ("fundusz", "Fundusz.exe", "Fundusz.ini", "fundusz"),
    KZP("kzp", "Kzp.exe", "Kzp.ini", "kzp"),
    PRZELEWY("przelewy", "Przelewy.exe", "Przelewy.ini", "przelewy"),
    WYPOSAZENIE("wyposazenie", "Wyposazenie.exe", "Wyposazenie.ini", "wyposazenie"),
    STOLOWKA("stolowka", "Stolowka.exe", "Stolowka.ini", "stołówka");

    private final String appName;
    private final String appExe;
    private final String appConfig;
    private final String appDirectoryConfig;

    private ListApps(String appName, String appExe, String appConfig, String appDirectoryConfig) {
        this.appName = appName;
        this.appExe = appExe;
        this.appConfig = appConfig;
        this.appDirectoryConfig = appDirectoryConfig;
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

    public String getAppDirectoryConfig() {
        return appDirectoryConfig;
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
     * Get name of directory with INI file
     *
     * @param arg App name (argument from main method)
     * @return name of firectory with INI file
     */
    public static String getDirectoryConfig(String arg) {
        String result = "";
        for (ListApps n : ListApps.values()) {
            if (n.getAppName().equals(arg.toLowerCase())) {
                result = n.getAppDirectoryConfig();
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
