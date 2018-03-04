/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kalat.gprogmanstarter.implementation;

import pl.kalat.gprogmanstarter.implementation.ArrayItem;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Kałat
 */
public class ArrayItemTest {

    private String configFile;
    private int rows;
    private String[][] arrayGood;
    private String[][] arrayWithSpace;
    private String[][] arrayBad;
    private ArrayItem arrayItem;

    @Before
    public void setUp() {
        this.configFile = "gProgmanStarter.config.TEST.ini";

        this.arrayGood = new String[][]{
            {"Szkoła podstawowa nr.4", "DB.A.ini"},
            {"Zespół Szkół nr.156", "DB.B.ini"},
            {"Przedszkole nr.44", "DB.C.ini"},
            {"Szkoła podstawowa nr.11", "DB.D.ini"},
            {"WSTI", "DB.E.ini"}
        };
        arrayItem = new ArrayItem(configFile);
    }

    @Test
    public void testCountRows() {
        rows = arrayItem.getRows();
        assertEquals(5, rows);
    }

    @Test
    public void testArrayPrepare() {
        assertArrayEquals(arrayGood, arrayItem.getArrayFileLine());
    }

}
