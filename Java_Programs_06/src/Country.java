package models;

/**
  * <h1> Country! <h1/>
  * <p> The Country object assimilates the name of a country, the number of vaccinations in the country and the
  * date on which the information was recorded. The class was intended to work with both the VaccineArrayApp
  * and the VaccineBSTApp. </p>
  * @author Bonga Njamela
  * @since 25-02-2022
  * @version 1.0
  */

public class Country implements Comparable<Country>{

    String name;//name fo the country
    String date;//the date on which the vaccination information was recorded
    String vaccinated;//the total number of vaccinations in the country at the given date
    static double key;
    
    /**
      * Empty constructor for the Country object.
      */
    public Country() {
        this.name = "";
        this.date = "";
        this.vaccinated = "";
    }
    
    /**
      * Explicit Country object constructor.
      * @param country This is the name of the country
      * @param day The date on which the vaccination information was collected
      * @param vaccines The number of vaccinations in the country
      */
    public Country(String country, String day, String vaxxed) {
        this.name = country;
        this.date = day;
        this.vaccinated = vaxxed;
        if ((country == "") || (day == "") || (vaxxed == "")) {
            this.name = "no name";
            this.date = "no date";
            this.vaccinated = "<Not found>";
        }
    }
        
    /**
      * Country object copy constructor
      */
    public Country(Country country) {
        this.name = country.getName();
        this.date = country.getDate();
        this.vaccinated = country.getVaccinated();
    }
    
    /**
      * Set the name of the country.
      * @param country The name of the country.
      */
    public void setName(String country) {
        this.name = country;
    }
    
    /**
      * Retrieve country name.
      * @return String Country name
      */
    public String getName() {
        return this.name;
    }
    
    /**
      * Record the date on which the number of vaccinations were recorded.
      * @param day Requires the date in the form YYYY-MM-DD
      */
    public void setDate(String day) {
        this.date = day;
    }
    
    /**
      * Retrieve the date on which the number of vaccinations were recorded.
      * @return String Country's vaccinations information date
      */
    public String getDate() {
        return this.date;
    }
    
    /**
      * Record the number of vaccinations in the country.
      * @param vaccines Total number of vaccinations on the given date
      */
    public void setVaccinated(String vaccines) {
        this.vaccinated = vaccines;
    }
    
    /**
      * Retrieve the number of vaccinated people in the country
      * @return String Number of vaccinations
      */
    public String getVaccinated() {
        return this.vaccinated;
    }
    
    /**
      * Gives the double value of vaccinations.
      * @return double - Double value of vaccinations
      * @param vaxxed The number of vaccinations represented as a string
      */
    public double vaxxedDoubleValue() {
        return Double.parseDouble(getVaccinated().trim());
    }
    
    public int vaxxedIntValue() {
        return Integer.parseInt(getVaccinated().trim());
    }
    /**
      * Creates the key for the data item using the name of the Country, ensuring no collisions.
      * @param someCountry Takes in an object of the Country class.
      * @return double <p>Returns -1.0 for a null argument, otherwise returns a double key value or returns 
      * -2.0 if the country has an empty name and number of vaccinated people.
      */
    static double key(Country someCountry) {
        
        double key = 0.0;
        String  countryName = " ";
        int nameInt = 0;//integer value of chars in Country name
        double nameDouble = 0.0;//the name of country as a double variable
        double vaxxedDouble = 0.0;//the number of vaccinations as a double variable
        
        if (someCountry == (Country)null) {
            return -1.0;
        }
        else {
            if (someCountry.getName().equals("")||someCountry.getName().equals(" ")) {//if name is empty then abort with -2.0
                return -2.0;            
            }
            else if (someCountry.getVaccinated().equals("")||someCountry.getVaccinated().equals(" ")) {
                return -3.0;
            }// if vaccinations are zero then return -3.0
            else {
                countryName = someCountry.getName();
                char[] chars = countryName.toCharArray();//convert country name to array of chars
                for (char c : chars) {
                    nameInt = c*11;//multiply each char by 11 and sum it up
                    nameDouble += ((Math.floor((nameInt*37)/7) 
                    + ((nameInt*37)/7)*1.618)*1000.000)/1000.000;//rounds of key to 3 decimal place
                }
                vaxxedDouble = Double.parseDouble(someCountry.getVaccinated());
                return key = nameDouble + vaxxedDouble;
            }
        }
    }
    
    /**
      * Overrides the compareTo method in the Comparable interface to compare two countries.
      * @param other Another country to be compared to this instance.
      * @return int Returns 0 if the Country object is null otherwise returns 1 if other Country is the same
      * as the instance but has a more vaccinations or -1 if other Country is different
      */
    public int compareTo(Country other) {
        
        if (other == (Country)null || (other.getName() == "" && other.getDate() == "")) {
            return 0;
        }
        else if (name.compareTo(other.getName()) == 0) {
            if (date.compareTo(other.getDate()) == 0) {
                return 3;
            }
        }
        else if (name.compareTo(other.getName()) <= 0) {
            if (date.compareTo(other.getDate()) <= 0) {
                return -2;
            }
        }
        else if (name.compareTo(other.getName()) <= 0) {
            if (date.compareTo(other.getDate()) > 0) {
                return -1;
            }
        }
        else if (name.compareTo(other.getName()) > 0) {
            if (date.compareTo(other.getDate()) <= 0) {
            return 1;
            }
        }
        else if (name.compareTo(other.getName()) > 0) {
            if (date.compareTo(other.getDate()) > 0) {
                return 2;
            }  
        }
        return 1;
    }
    
    /**
      * <p> Overrides the equals method of the Object class. Verifies equality between two Country objects
      * </p>
      * @param other The other country to be equated with this instance of Country
      * @return boolean Returns true if other Country is the same as this Country object
      */
    public boolean equals(Country other) {
        
        if (name.equals(other.name) && date.equals(other.date) && vaccinated.equals(other.vaccinated)) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return name + " " + date + " " + vaccinated;
    }
}
