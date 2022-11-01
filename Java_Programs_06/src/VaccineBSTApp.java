import models.CountryRegister;
import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinaryTreeNode;
import binarysearchtree.VaccinationsBST;
import models.Country;
import java.util.*;
import java.io.*;

/**
  * <h1> Vaccination Binary Search Tree App </h1>
  * <p>
  * Application asks user to enter a date and a list of countries and returns the number of vaccinations for
  * each country on that date in the same sequence. Uses a binary search tree data structure to handle data.
  * - Aim: To compare the Binary Search Tree with a traditional unsorted array data structure.
  * </p>
  * @author Bonga Njamela [NJMLUN002]
  * @version 1.0
  * @since 08-03-2022
  */

public class VaccineBSTApp {
    
    static Scanner keyboard;
    
    public static void main(String[] args) {
        
        keyboard = new Scanner(System.in);
        header();
        ArrayList<String> listOfNames = new ArrayList<String>();//for holding user search country name only
        Country country;
        String fileName = args[0];
        VaccinationsBST.generateBST(fileName);//produce BST
        
        
        System.out.println("Enter the date: ");
        String searchDate = keyboard.nextLine();
        System.out.println("Enter the list of countries (end with an empty line): ");
        
        String countryname = " ";
        do {//collect names from user
            countryname = keyboard.nextLine();
            listOfNames.add(countryname);
        } while (!countryname.equals(""));
        
        System.out.println("Results: ");
        String name = " ";
        int n;
        for (n = 0; n < listOfNames.size(); n++) { 
            name = listOfNames.get(n);
            country = new Country(name, searchDate, "0");//create a country with unknown vaccinations
            Country found = VaccinationsBST.bst.find(country);//search country in bst
            if (found != null) {
                System.out.println(found.getName() + " = " + found.getVaccinated());
            }
            else if (!(n == listOfNames.size()-1)) {
                System.out.println(name + " = <Not found>");
            }
            else{
                System.out.println();
                System.out.println("Done!");
            }
        }
        footer();
        opCount();
    }
    
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
        System.out.println(wspace24 + "   Vaccination BST App  " + wspace24);
        System.out.println();
        System.out.println(wspace8 + "Provides the total number of vaccinations in a country  " + wspace8);
        System.out.println(wspace8 + "on a given date* using a binary search tree data        " + wspace8);
        System.out.println(wspace8 + "structure to experimentally compare the operation of a  " + wspace8);
        System.out.println(wspace8 + "binary search tree data structure to a tradiational     " + wspace8);
        System.out.println(wspace8 + "array.                                                  " + wspace8);                            
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
    
       static void opCount() {
        
        try {
            FileWriter fileWObj = new FileWriter("opCountBST.txt");               
            fileWObj.write("Total opCount" + " = " + BinarySearchTree.opCount);
            fileWObj.close();
        } 
        catch (IOException e){
            System.out.println("Failed to write to file.");
            e.printStackTrace();
        }
    }
}
