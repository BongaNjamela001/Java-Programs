import java.util.Scanner;
import java.util.Arrays;

/**
  * Plane object inherits Vehicle colour and passenger number and has manufacturer
  * and model number.
  *
  *
  * @author: Bonga Njamela
  * @version: 09/11/20
  */
  
  public class Plane extends Vehicle{
      
      //Plane instance variables includes the same variables as Vehicle
      private String colour;
      private int passengers;
      private String company;
      private int series;
      
      //Creates plane object and inherits methods from Vehicle base class
      public Plane(String anyColour, int people, String manufacturer, int modelNumber) {
         super(anyColour, people);
         this.company = manufacturer;
         this.passengers = people;
         this.series= modelNumber;
      }
      
      //Invokes toString method from super class to return the Vehicle colour and number
      //of passengers
      public String toString() {
         return super.toString() + " " + this.company + " " + this.series;
      }
  }