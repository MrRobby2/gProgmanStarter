package pl.kalat.gprogmanstarter.implementation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Kałat
 */
public class ListAppsTest {

    private String nameApp;
    private String result;
    private String nameConfig;
    private String nameExe;

    @Before
    public void setUp() {
        this.nameApp = "kadry";
        this.result = "";
        this.nameConfig = "";
        this.nameExe = "Kadry.exe";
    }

    @Test
    public void testToString() {
        assertEquals(ListApps.KADRY.toString(), nameExe);
    }

    @Test
    public void testToStringFail() {
        nameExe = "Kadry.ini";
        assertNotEquals(ListApps.KADRY.toString(), nameExe);
    }

    @Test
    public void testCheckAppNameOnList() {
        assertTrue(ListApps.checkAppName(nameApp));
    }

    @Test
    public void testCheckLowerAppNameOnList() {
        nameApp = "KADry";
        assertTrue(ListApps.checkAppName(nameApp));
    }

    @Test
    public void testCheckWrongAppNameOnList() {
        nameApp = "Kr3vt3cADry";
        assertFalse(ListApps.checkAppName(nameApp));
    }

    @Test
    public void testAllProgmanApp() {
        String nameExe2 = "Place.exe";
        String nameExe3 = "Zlecone.exe";
        String nameExe4 = "Przelewy.exe";
        String nameExe5 = "Finanse.exe";
        String nameExe6 = "Rozrachunki.exe";
        String nameExe7 = "Kasa.exe";
        String nameExe8 = "Magazyn.exe";
        String nameExe9 = "Fundusz.exe";
        String nameExe10 = "Kzp.exe";
        String nameExe11 = "Stolowka.exe";
        String nameExe12 = "Wyposazenie.exe";
        String nameExe13 = "Biblioteka.exe";
        
        assertEquals(ListApps.KADRY.toString(), nameExe);
        assertEquals(ListApps.PLACE.toString(), nameExe2);
        assertEquals(ListApps.ZLECONE.toString(), nameExe3);
        assertEquals(ListApps.PRZELEWY.toString(), nameExe4);
        assertEquals(ListApps.FINANSE.toString(), nameExe5);
        assertEquals(ListApps.ROZRACHUNKI.toString(), nameExe6);
        assertEquals(ListApps.KASA.toString(), nameExe7);
        assertEquals(ListApps.MAGAZYN.toString(), nameExe8);
        assertEquals(ListApps.FUNDUSZ.toString(), nameExe9);
        assertEquals(ListApps.KZP.toString(), nameExe10);
        assertEquals(ListApps.STOLOWKA.toString(), nameExe11);
        assertEquals(ListApps.WYPOSAZENIE.toString(), nameExe12);
        assertEquals(ListApps.BIBLIOTEKA.toString(), nameExe13);
    }

    @Test
    public void testGetNameExe() {
        nameExe = ListApps.getNameExe(nameApp);
        result = "Kadry.exe";

        assertEquals(result, nameExe);
    }

    @Test
    public void testGetLowerNameExe() {
        nameApp = "KADry";
        nameExe = ListApps.getNameExe(nameApp);
        result = "Kadry.exe";

        assertEquals(result, nameExe);
    }

    @Test
    public void testGetNameConfig() {
        nameConfig = ListApps.getNameConfig(nameApp);
        result = "Kadry.ini";

        assertEquals(result, nameConfig);
    }

    @Test
    public void testGetDirectoryConfig() {
        nameConfig = ListApps.getDirectoryConfig("kasa");
        result = "kasa ddj";

        assertEquals(result, nameConfig);
    }
    
    @Test
    public void testGetDirectoryConfig2() {
        nameConfig = ListApps.getDirectoryConfig("stolowka");
        result = "stołówka";

        assertEquals(result, nameConfig);
    }
    
    @Test
    public void testGetLowerNameConfig() {
        nameApp = "KADry";
        nameConfig = ListApps.getNameConfig(nameApp);
        result = "Kadry.ini";

        assertEquals(result, nameConfig);
    }

}
