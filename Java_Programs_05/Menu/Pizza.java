import java.util.Scanner;
import java.util.Arrays;

/**
  * 
  *
  */
  
  public class Pizza extends Menu {
   
      private String item;//menu item number
      private String size;//large,medium,small
      private String base;//thick or thin
      private String cheese;//yes or no
      private String garlic;//yes or no
      
      public Pizza(String itemNumber, String pizzaSize) {
         super("Pizza", itemNumber, pizzaSize);
         this.base = " ";
         this.cheese = "No";
         this.garlic = "No";
      }
      
      public String getPizza() {
         return super.itemNumber();
      }
      
      public String getPizzaSize() {
         return super.getSize();
      }
      
      public void baseType(String anybase) {
         this.base = anybase;
      }
      
      public String getBaseType() {
         return this.base;
      }
      
      public void extraCheese() {
         this.cheese = "Yes";
      }
      
      public void extraGarlic()  {
         this.garlic = "Yes";
      }
      
      public String toString() {
         return super.toString() + ", " + this.base + ", " + this.cheese + ", " + this.garlic;
      }
  }