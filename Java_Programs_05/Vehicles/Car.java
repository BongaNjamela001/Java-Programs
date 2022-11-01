import java.util.Scanner;
import java.util.Arrays;

/**
  * Car is a Vehicle object with a number of passengers, a colour and an
  * additional number of doors.
  *
  *
  * @author: Bonga Njamela
  * @version: 09/11/20
  */
  
  public class Car extends Vehicle {
  
      //Car instance variables
      private int doors;
      private int passengers;
      private String colour;
      
      //Car constructor calling super class Vehicle
      public Car(String anyColour, int people, int doorNumber) {
         
         super(anyColour, people);//Car object inherits instance variables of Vehicle object
         this.doors = doorNumber;
         this.colour = anyColour;
         this.passengers = people;
         
      }
      
      public String toString() {
         
         if (this.doors==1||this.doors==-1){
            return super.toString() + " " + this.doors + " door"; 
         }
         return super.toString()+ " " + this.doors + " doors";  
      }
  }