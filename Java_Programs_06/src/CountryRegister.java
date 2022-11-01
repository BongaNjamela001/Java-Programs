package models;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
  * <h1> Country Register </h1>
  * <p> The Country Register class is a descendant class of the Country class. Primarily for storing Country
  * objects in an array. Created to compare the operation efficiency of array data structures to binary search 
  * tree data structures.
  * </p>
  * @author Bonga Njamela [NJMLUN002]
  * @since 27-02-2022
  * @version 1.7
  */

public class CountryRegister extends Country {
    static Country[] countries;//array of countries
    static String[][] datesAndCountries; //2D array for storing a unique date and information recorded on that date
    static int numCountries;//number of countries counter
    static int totalCountries;//total unique country names in file
    static int totalDates;//total unique date when data was recorded
    static String fileName;
    public static int opCount;
    
    /**
      * Generic Country Register constructor. 
      */
    public CountryRegister() {
        countries = new Country[235];
        numCountries = 0;
        totalCountries = 0;
        totalDates = 0;
        fileName = "";
        opCount = 0;
    }
    
    /**
      * Constructor creates a Country Register from a file given a file name 
      */
    public CountryRegister(String file) {
        totalCountries = totalCountries(file);
        totalDates = totalDates(file);
        countries = new Country[totalCountries];
        datesAndCountries = new String[totalDates][totalCountries+1];
        fileName = file;
        numCountries = 0;
        opCount = 0;
    }
    
    /**
      * Programmatically calculates the total number of unique country names in a given file.
      * @param file Requires file name.
      * @return int - This is the total number of unique country names in the file.
      */
    static int totalCountries(String file) {
        
        int num = 0;//country tally
        ArrayList<String> names = new ArrayList<String>();//used to add country names without duplication
        String name = "no name";
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(file)))) {
        
        String line = "";
        while ((line = buffer.readLine()) != null) {
//             if (line.indexOf("\"") != -1) {//eliminate the column titles
//                 line = buffer.readLine();
//             }
            line = buffer.readLine();
            if (line != null) {
                String[] linestr = line.split(",");//separate each column in file
                name = linestr[0];//if name is in first column
                if (!names.contains(name)) {//check if name is in arraylist
                    names.add(name);//add name to array list
                }
                else {
                    continue;//if name is in arraylist continue
                }
            }
        }
        buffer.close();
        }
            
        catch (FileNotFoundException e) {
            System.out.println("File not found");//
            e.printStackTrace();
        }
        
        catch (IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
        totalCountries = names.size();
        return totalCountries;      
    }
    
    /**
      * Calculates the number of unique dates in the file.
      * @param file Requires file name as argument
      * @return int - Total number of dates in the file
      */
    static int totalDates(String file) {
        
        int num = 0;//country tally
        ArrayList<String> dates = new ArrayList<String>();
        String date = "no date";
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(new File(file)))) {
        
        String line = "";
        while (line != null) {
//             if (line.indexOf("\"") != -1) {
//                 line = buffer.readLine();
//             }
            line = buffer.readLine();
            if (line != null) {
                String[] linestr = line.split(",");
                date = linestr[1];
                if (!dates.contains(date)) {
                    dates.add(date);
                }
//                 else {
//                     continue;
//                 }
            }
        }       
        buffer.close();
        }
            
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        
        catch (IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }
        totalDates = dates.size();//total dates equal to size of arraylist
        return totalDates;      
    }
    
    /**
      * Generates an array with countries and the sum total of vaccinations to date.
      * @see addCountry
      * @param file Requires file name.
      */
    public static void generateCountriesTotal(String file) {  
    
        StringBuilder sb = new StringBuilder();
        String doubleLine = "";
        BufferedReader br=null;
        String newData = "";
        int lineCount, commaCount, totalVaxxed;
        lineCount = 0;
        commaCount = 0;
        totalVaxxed = 0;
        countries = new Country[totalCountries(file)]; 
        String name = " ";
        String date = " ";
        String vaxxed = " ";
        String countryData = "";
        try{
        
        br = new BufferedReader(new FileReader(new File(file)));
        
        String line = null;        
        while((line = br.readLine()) != null) {//read all non-empty lines in file until
            
            
            if (lineCount > 0 ) {//start reading none empty lines
                if (line.indexOf("\"") != -1) {//check for quotation marks at end of line
                    doubleLine = br.readLine();
                }
                doubleLine = br.readLine();
                if (doubleLine != null) {
                    sb.append(doubleLine);//build whole line
                    String[] dataStrArr = sb.toString().split(",");//separate data
                    for (String str: dataStrArr) {
                        if (str.equals("")) {
                            commaCount++;
                            str = "0";
                        }
                        else {
                            commaCount++;
                        }
                        if (commaCount == 1) {
                            name = str;//country name
                        }
                        else if (commaCount == 3) {
                            date = str;
                        }
                        else if (commaCount == 4) {
                            vaxxed = str;
                        }
                    }
                }
                else {
                    break;
                }
                Country buildCountry = new Country(name, date, vaxxed);//created country
                addCountry(buildCountry);//add to register
            }
            commaCount = 0;//reset comma count
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
    
    /**
      * <p> 
      * Generates a 2D array with a unique date as first entry in each array and the list of countries and 
      * vaccinations with information recorded on the date in the first position of the array. Each array
      * has totalDates-by-totalCountries dimension so that each unique date has information recorded about
      * a country and its vaccinations. 
      * </p>
      * @param file Requires file name.
      */
    public static void generateTotalData(String file) {  
    
        StringBuilder sb = new StringBuilder();
        BufferedReader br=null;
        int lineCount, totalVaxxed, commaCount;
        lineCount = 0;
        totalVaxxed = 0;
        commaCount = 0;
        datesAndCountries = new String[totalDates(file)][totalCountries(file)+1]; 
        String name = " ";
        String date = " ";
        String vaxxed = " ";
        String countryData = "";
        try{
        
            br = new BufferedReader(new FileReader(new File(file)));
            
//             String doubleLine = br.readLine();
            String doubleLine = "";
            while(doubleLine != null) {//read all non-empty lines in file
                
//                 if (lineCount => 0 ) {//start reading none empty lines
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
//                     for (String str: dataStrArr) {
//                         if (str.equals("")) {
//                             commaCount++;
//                             str = "0";
//                         }
//                         else {
//                             commaCount++;
//                         }
//                         if (commaCount == 1) {
//                             name = str;//country name
//                         }
//                         else if (commaCount == 3) {
//                             date = str;
//                         }
//                         else if (commaCount == 4) {
//                             vaxxed = str;
//                         }
//                     }
//                     }
                    Country buildCountry = new Country(name, date, vaxxed);//created country
                    int datePosition = addDate(date);// get position of date in the array
                    addData(datePosition, buildCountry);//go to date position and add country vaccination info
                }
                commaCount = 0;
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
    
    /**
      * <p>
      * Auxiliary method for adding date into the first entry of each 2D array and returns the position
      * in which the date was added for easy access. Can be viewed as returning the row number corresponding 
      * to the added date.
      * </p>
      * @param date Requires the date to be added into first empty space in 2D array
      * @return int - The position in the 2D array in which the date was added.
      */
    static int addDate(String date) {
        for (int i = 0; i < totalDates; i++) {//each unique date
            if (datesAndCountries[i][0] != (String) null) {//if there's already date in position
                if (datesAndCountries[i][0].equals(date)) {//check for equality with new date entry
                    opCount++;
                    return i;//if the dates are the same, return the position
                }
            }
            else {//there is no date in this row
                datesAndCountries[i][0] = date;//add new date entry
                return i;//return the position in which it was added
            }
        }
        return -2;//failed to add anything
    }
    
    /**
      * <p>
      * For adding country vaccination information to corresponding data collection date.
      * </p>
      * @param datePos The position of the date in the 2D array
      */
    static void addData(int datePos, Country country) {
        int i = 0, j = 1;// i -> date loop index, j->country name and total vaxxed loop index
        
        if (datesAndCountries[datePos][0].equals(country.getDate())) {//go to the row with corresponding date
            for (j = 1; j < totalCountries+1; j++) {//for each empty position next to date
                if (datesAndCountries[datePos][j] == (String)null){
                    opCount++;
                    datesAndCountries[datePos][j] = country.getName() + " = " + country.getVaccinated();//add data
                    break;
                }
                else {
                    continue;
                }
            }
        }
    }
    
    /**
      * Adds a country to a 1D array which stores the total vaccinations in a country for all time.
      * @param country Country object to be added to array
      */
    static void addCountry(Country country) {
        double vaxxed = country.vaxxedDoubleValue();
        int index = 0;
        int compareTotal = 0;//uses compareTo in Country class
        int position = countryEntryPosition(country.getName());
        
        if (position != -2) {//if the country name already in the array
            compareTotal = countries[position].compareTo(country);//compare total vaccinations
                if (compareTotal == 1) {//entry total < argument total => replace
                    countries[position].setVaccinated(country.getVaccinated());
                    countries[position].setDate(country.getDate());
                    opCount++;
                }
        }
        else {//argument name not in array
            for (index = 0; index < totalCountries; index++) {
                if (countries[index] == (Country)null) {
                    opCount++;
                    countries[index] = country;
                    break;
                }
                else {
                    continue;
                }
            }
        }
    }
    
    /**
      * Gives the array index of the country that has been added to the class's 1D array.
      * @param name String name of country.
      * @return int - Array index of country in 1D array.
      */
    static int countryEntryPosition(String name) {
        for (int index = 0; index < totalCountries; index++) {
           if (countries[index] != (Country) null) {
               if ((countries[index]).getName().equalsIgnoreCase(name)) {
                  opCount++;
                  return index;
               }
           }
        }
        return -2;
    }
    
    /**
      * Gives the array index of the date that has been added to the class's 2D array.
      * @param date String date.
      * @return int - Array index of date in 2D array.
      */
    static int dateEntryPosition(String date) {
        for (int i = 0; i < totalDates; i++) {
            if (datesAndCountries[i][0] != (String)null) {
                if ((datesAndCountries[i][0]).equals(date)) {
                    opCount++;
                    return i;
                }
            }
        }
        return -2;
    }
    
    /**
      * Returns the Country object stored in the 1D array, given the country's name, provided it exists.
      * @param name Requires country name
      * @return Country - Country object returned if it exists in array
      */
    static Country retrieve(String name) {
        Country searchCountry = new Country();
        for (int index = 0; index < totalCountries+1; index++) {
            if (countries[index] != (Country)null) {
                if ((countries[index].getName().equalsIgnoreCase(name))) { 
                   opCount++;
                   return countries[index];
                }
            }
        }
        return searchCountry; 
    }
    
    /**
      * Returns the date stored in the 2D array provided it exists.
      * @param date Requires date to be searched in array
      * @return String - Date returned if it exists else same date is returned.
      */
    static String retrieveDate(String date) {
        for (int i = 0; i < totalDates; i++ ) {
            if (datesAndCountries[i][0] != (String)null) {
                if(datesAndCountries[i][0].equals(date)) {
                    opCount++;
                    return datesAndCountries[i][0];
                }
            }
        }
        return date;
    }
    
    /**
      * Returns the country and the number of vaccinations recorded on a given date as stored in the 2D array.
      * @param date The date on which data was recorded.
      * @param name The name of the country.
      * @return String - "name = totalvaccinations".
      */
    public static String findCountry(String date, String name) {
        
        if (name.equals("")) {
            System.out.println();
            return "Done!";
        }
        
        for (int i = 0; i < totalDates; i++) {
            if (datesAndCountries[i][0].equals(date)) {
                opCount++;
                for (int j = 1; j < totalCountries + 1; j++) {
                    if (datesAndCountries[i][j] != (String) null) {
                        String[] entry = datesAndCountries[i][j].split("=");
                        String e = entry[0];
                        if ((e.trim().equalsIgnoreCase(name))) {
                            opCount++;
                            return datesAndCountries[i][j];
                        }
                    }
                }
            }
        }
        return name + " = " +"<Not Found>";
    }
    
    /**
      * Prints all unique dates on which vaccinations took place as recorded in file.
      */
    static void allDates() {
        for (int i = 0; i < totalDates; i++) {
            System.out.println(datesAndCountries[i][0]);
        }
    }
    
    /**
      * Prints all the information recorded on a given date.
      * @param date Required date.
      */
    public static void printDateData(String date) {
        if (dateEntryPosition(date) != -2) {
            for (int j = 1; j < totalCountries + 1;j++) {
                if (datesAndCountries[dateEntryPosition(date)][j] != null) {
                    opCount++;
                    System.out.println(datesAndCountries[dateEntryPosition(date)][j]);
                }
                else {
                    break;
                }
            }
        }
        else {
            System.out.println("<No vaccinations recorded for this date>");
        }
    }
    
    /**
      * Prints the countries and the total vaccinations to date.
      */
    public static void printAllCountries() {
        for (Country c : countries) {
            if (c != null)
                System.out.println(c);
            else {
                break;
            }
        }
    }
    
    /**
      * Prints the total vaccinations in a country to date.
      */
    public static void print(String name) {
        if (countryEntryPosition(name) != -2) {
            System.out.println(retrieve(name).toString());
        }
        else {
            System.out.println("Not found");
        }
    }
    
    /**
      * Checks whether the country has been added to 1D array.
      * @param country Country object to check for in array.
      * @return boolean - Returns true if country is in array or false otherwise.
      */
    public static boolean contains(Country country) {
        for (int index = 0; index < totalCountries; index++) {
           if (countries[index] != (Country) null) {
               opCount++;
               if ((countries[index]).getName().equalsIgnoreCase(country.getName())
               && (countries[index]).getDate().equals(country.getDate())) {
                  opCount++;
                  return true;
               }
           }
        }
        return false;
    }
    
    /**
      * Checks if any country has been added to arrays.
      * @return boolean - True if at least one country has been processed, otherwise false.
      */
    static boolean isEmpty() {
        if (numCountries == 0) {
            return true;
        }
        return false;
    }
}
