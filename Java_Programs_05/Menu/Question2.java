import java.util.Scanner;
import java.util.Arrays;

public class Question2{
      
      public static void main(String args[]){
         
         /**initial screen to select create either a Pizza, Curry, SoftDrink object
           * or delete or show menu item(s).
           */
         
         Scanner keyboard = new Scanner(System.in);
         String action1, action2;//can be P, C, S, D, L, or Q for prompting action
         String size, base, cheese, garlic, curry, flavour, container, itemNumber;
         int i=0;
         MenuOrders listOfOrders = new MenuOrders();
         System.out.println("Welcome to Great International Food Court");
         System.out.println("MENU: add (P)izza, add (C)urry, add (S)oft drink, (D)elete, (L)ist, (Q)uit");
         action1 = keyboard.next();
         action2 = action1;
         
         if (action1.equalsIgnoreCase("Q"))  {//if Q, program ends
            System.exit(0);
         }
         
         else{
            
            while (!action2.equalsIgnoreCase("Q")) {   
               
                  //creating Pizza item
                  if (action2.equalsIgnoreCase("P"))  {
                     System.out.println("Enter the menu item number");
                     itemNumber = keyboard.next();
                     System.out.println("Enter the size");
                     size = keyboard.next();
                     System.out.println("Enter the base");
                     base = keyboard.next();
                     System.out.println("Enter extra cheese");
                     cheese = keyboard.next();
                     System.out.println("Enter extra garlic");
                     garlic = keyboard.next();
                     System.out.println("Done");
                     Pizza pizza = new Pizza(itemNumber, size);
                     
                     if (cheese.equalsIgnoreCase("yes")||cheese.equalsIgnoreCase("y")) {
                        pizza.extraCheese();
                     }
                     
                     if (garlic.equalsIgnoreCase("yes")||cheese.equalsIgnoreCase("y")) {
                        pizza.extraGarlic();
                     }
                     
                     pizza.baseType(base);
                     Menu pizza2 = new Menu("Pizza", itemNumber, size);
                     listOfOrders.addOrder((Menu)pizza);
                            
                  }
                  //creating Curry item
                  else if (action2.equalsIgnoreCase("C")){
                     System.out.println("Enter the menu item number");
                     itemNumber = keyboard.next();
                     System.out.println("Enter the size");
                     size = keyboard.next();
                     System.out.println("Enter the curry type");
                     curry = keyboard.next();
                     System.out.println("Done");
                     Curry curry1 = new Curry(itemNumber, size);
                     curry1.curry(curry);
                     listOfOrders.addOrder((Menu)curry1);
                  }
                  
                  //creating SoftDrink item
                  else if (action2.equalsIgnoreCase("S")) {
                     System.out.println("Enter the menu item number");
                     itemNumber = keyboard.next();
                     System.out.println("Enter the size");
                     size = keyboard.next();
                     System.out.println("Enter the flavour");
                     flavour = keyboard.next();
                     System.out.println("Enter whether it is a bottle or can");
                     container = keyboard.next();
                     System.out.println("Done");
                     SoftDrink drink1 = new SoftDrink(itemNumber, size);
                     drink1.container(container);
                     drink1.flavour(flavour);
                     listOfOrders.addOrder((Menu)drink1);
                  }
                  
                  //Deleting the Menu item with number 
                  else if (action2.equalsIgnoreCase("D")) {
                     System.out.println("Enter the menu item number");
                     itemNumber = keyboard.next();
                     
                     if (listOfOrders.contains(itemNumber)) {
                        listOfOrders.delete(itemNumber);
                        System.out.println("Done");
                     }
                     else {
                        System.out.println("Not found");
                     }
                  }
                  
                  //listing the Menu item with list 
                  else if (action2.equalsIgnoreCase("L")) {
                    
                     Menu[] ordersArray = listOfOrders.getOrders();
                     for (int j=0; j<500; j++) {
                        if (ordersArray[j] != (Menu) null) {
                           System.out.println(ordersArray[j].toString());
                        }
                        else
                           continue;
                     }
                     System.out.println("Done");
                  }
                  else {
                      System.out.println("Please try again");
                  }
               System.out.println("MENU: add (P)izza, add (C)urry, add (S)oft drink, (D)elete, (L)ist, (Q)uit");
               action2 = keyboard.next();
               i++;
            }
         }
    }
}