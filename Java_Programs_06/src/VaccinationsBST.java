package binarysearchtree;

import models.CountryRegister;
import models.Country;
import java.util.*;
import java.io.*;

/**
  * <h1> Vaccinations Binary Search Tree </h1>
  * Generates a binary search tree to store vaccination information from a given file.
  * @author Bonga Njamela [NJMLUN002]
  */

public class VaccinationsBST extends BinarySearchTree {
    
    static String fileName;
    static int treeSize;//equivalent to all the data in the file
    public static BinarySearchTree<Country> bst;
    
    /**
      * Generic VaccinationsBST constructor.
      */
    public VaccinationsBST() {
        fileName = " ";
        treeSize = 0;
        bst = null;
    }
    
    /**
      * VaccinationsBST constructor sets file name.
      * @param file File name from which binary search tree data will be retrieved.
      */
    public VaccinationsBST(String file) {
        fileName = file;
        treeSize = 0;
        bst = null;
    }
    
    /**
      * <p> Generates the binary search tree from file by reading each line and creating a Country object.
      * Country object is then added to binary search tree using insert algorithm.</p>
      * @param file File name to retrieve data.
      * @see binarysearchtree.BinarySearchTree
      * @see binarysearchtree.BinaryTreeNode
      * @see models.Country
      * @throws ioException
      */
    public static void generateBST(String file) {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        int lineCount, numCountries;
        lineCount = 0;
        numCountries = 0;
        bst = new BinarySearchTree<Country>();
        String name = " ";
        String date = " ";
        String vaxxed = " ";
        String countryData = "";
        
        try{
            br = new BufferedReader(new FileReader(new File(file)));
            String doubleLine = " ";
            
            while(doubleLine != null) {//read all non-empty lines in file
            
                if (lineCount >= 0 ) {//start reading none empty lines
                    doubleLine = br.readLine();
                    if (doubleLine != null) {
                    sb.append(doubleLine);//build whole line
                    String[] dataStrArr = sb.toString().split(",");//separate data
                    name = dataStrArr[0];
                    date = dataStrArr[1];
                    if (dataStrArr.length == 3) {
                        vaxxed = dataStrArr[2];
                    }
                    else {
                        vaxxed = "0";
                    }
                    }
                    Country buildCountry = new Country(name, date, vaxxed);//created country
                    bst.insert(buildCountry);
                    treeSize++;
                }
                lineCount++;//increment number of lines read
                numCountries++;//increment number of countries
                sb = new StringBuilder();
            }
            br.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
    }
}
