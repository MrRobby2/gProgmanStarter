package pl.kalat.gprogmanstarter.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Robert Kałat
 */
public class ArrayItem {

    private final String[][] arrayFileLine;
    private final String configFile;
    private final int rows;

    public ArrayItem(String configFile) {
        this.configFile = configFile;
        this.rows = countRows(configFile);
        this.arrayFileLine = prepareArrayItem(configFile);
        
    }

    /**
     * read config file and create array with 
     * [0][0] name of posiotion in choiceBox
     * [0][1] db config file name
     */
    private String[][] prepareArrayItem(String configFile) {
        String[][] array = new String[rows][2];
        try {
            File fileDir = new File(configFile);
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"))) {
                for (String[] array1 : array) {
                    String[] line = in.readLine().split(";");
                    array1[0] = line[0].trim();
                    array1[1] = line[1].trim();
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Brak pliku");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array;
    }

    /**
     * read config file and count rows
     * @param configFile config.ini with db_name:db_config.ini
     * @return number of rows
     */
    private int countRows(String configFile) {
        int rows = 0;
        try {
            File fileDir = new File(configFile);
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"))) {
                while ((in.readLine()) != null) {
                    rows++;
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }

    public String[][] getArrayFileLine() {
        return arrayFileLine;
    }

    public String getConfigFile() {
        return configFile;
    }

    public int getRows() {
        return rows;
    }    
}
