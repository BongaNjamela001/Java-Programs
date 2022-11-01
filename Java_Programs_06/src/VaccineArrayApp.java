import models.CountryRegister;
import java.util.*;
import java.io.*;

/**
  * <h1> Vaccination Array App </h1>
  * <p>
  * Application asks user to enter a date and a list of countries and returns the number of vaccinations for
  * each country on that date in the same sequence. Uses an array data structure to store data.
  * - Aim: To compare the Binary Search Tree with a traditional unsorted array data structure.
  * </p>
  * @author Bonga Njamela [NJMLUN002]
  * @version 1.0
  * @since 07-03-2022
  */

public class VaccineArrayApp {
    
    static Scanner keyboard;
    
    public static void main(String[] args) {
        
        keyboard = new Scanner(System.in);
        header();
        ArrayList<String> listOfNames = new ArrayList<String>();
        
        String fileName = "vaccinations.csv";
        CountryRegister array = new CountryRegister(fileName); 
        array.generateTotalData(fileName);
        
        
        
        System.out.println("Enter the date: ");
        String searchDate = keyboard.nextLine();
        System.out.println("Enter the list of countries (end with an empty line): ");
        
        String countryname = " ";
        do {
            countryname = keyboard.nextLine();
            listOfNames.add(countryname);
        } while (!countryname.equals(""));
        
        if (countryname.equals("")) {
            System.out.println("Results: ");
            for (int n = 0; n < listOfNames.size(); n++) {
                System.out.println(CountryRegister.findCountry(searchDate, listOfNames.get(n)));
            }
        }
        footer();
        opCount();
    }
    
    /**
      * Prints out top stars and dashes for appearance and application description in header.
      */
    static void header() {
        String star = "*", bar ="-", wspace24 ="                        ", wspace8 = "        ";
      
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
        for (int s = 0; s < 24*3;s++) {
            System.out.print(star);
        }
        System.out.println();
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
        System.out.println();
        System.out.println(wspace24 + "Vaccination Array App" + wspace24);
        System.out.println();
        System.out.println(wspace8 + "Provides the total number of vaccinations in a country  " + wspace8);
        System.out.println(wspace8 + "on a given date* using an array data structure to       " + wspace8);
        System.out.println(wspace8 + "experimentally compare to the operation of a binary     " + wspace8);
        System.out.println(wspace8 + "search tree data structure.                             " + wspace8);
        System.out.println();
        System.out.println(wspace8 + "Press ENTER after each entry.                           " + wspace8);
        System.out.println();
        System.out.println(wspace8 + "* Required date format YYYY-MM-DD.                      " + wspace8);
        System.out.println();
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
        for (int s = 0; s < 24*3;s++) {
            System.out.print(star);
        }
        System.out.println();
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
    }
    
    /**
      * Prints out bottom stars and dashes for appearance.
      */
    static void footer() {
        
        String star = "*", bar ="-", wspace24 ="                        ", wspace8 = "        ";
    
        System.out.println();
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
        for (int s = 0; s < 24*3;s++) {
            System.out.print(star);
        }
        System.out.println();
        for (int b = 0; b < 24*3;b++) {
            System.out.print(bar);
        }
        System.out.println();
    }
    
    /**
      * Prints out the instrumentation of program to file named opCount
      */
    static void opCount() {
        
        try {
            FileWriter fileWObj = new FileWriter("opCount.txt");               
            fileWObj.write("Total opCount" + " = " + CountryRegister.opCount);
            fileWObj.close();
        } 
        catch (IOException e){
            System.out.println("Failed to write to file.");
            e.printStackTrace();
        }
    }
}
