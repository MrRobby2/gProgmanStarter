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

    /**
         * read config file and create array with 
         * [0][0] name of posiotion in choiceBox
         * [0][1] db config file name
    */
    public static String[][] prepareArrayItem(String configFile) {
        int rows = 0;
        rows = countRows(configFile);
        
        String[][] arrayFileLine = null;
        arrayFileLine = prepareMenu(configFile, rows);
        
        return arrayFileLine;
    }

    private static int countRows(String configFile) {
        int rows = 0;

        try {
            File fileDir = new File(configFile);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            while ((in.readLine()) != null) {
                rows++;
            }
            in.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }

    private static String[][] prepareMenu(String configFile, int rows) {
        String[][] array = new String[rows][2];
        try {
            
            File fileDir = new File(configFile);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            for (int i = 0; i < array.length; i++) {
                String[] line = in.readLine().split(";");
                array[i][0] = line[0].trim();
                array[i][1] = line[1].trim();
            }
            in.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array;
    }
}