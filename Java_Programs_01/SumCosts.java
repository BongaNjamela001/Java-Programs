/**
Program asks the user to enter a series of rand amounts, adds them and returns the result
Author: Bonga Njamela
E-mail address: njmlun002@myuct.ac.za
Last Changed: August 31, 2020 
*/

import java.util.Scanner;
import java.lang.Math;

public class SumCosts
{
   public static void main(String[] args)
   {  
      
      Currency rand; //declaring the variable rand that stores a Currency value 
      String firstAmount, newAmount, totalAmount; //declaring the variable firstAmount and newAmount that stores a Money value
      rand = new Currency("R", "ZAR", 100);
      
      Scanner keyboard1, keyboard2;
      keyboard1 = new Scanner(System.in);
      System.out.println("Enter an amount or \'[D]one\' to print the sum and quit:");
      firstAmount = keyboard1.next();
      
      /**
      <p> first if checks whether the first user entry is '[D]one'
          If first entry is '[D]one', terminate the program
      */
      
      if ((firstAmount.equals("D") == true)||(firstAmount.equals("Done") == true)){
         
         System.out.print("Total: R0.00");
         System.exit(0);
      
      }
      else if ((firstAmount.equals("D") == false)||(firstAmount.equals("Done") == false)){
          
         Money newMoney, sumTotal, firstMoney;
         newAmount = "R0.00";
         
         /**
         <p> while loop sums every new money entry using the add method of the Money object
         <p> once '[D]one' is entered, program prints out the total
         */
         while ((newAmount.equals("D") == false)||(newAmount.equals("Done") == false)){
               
               System.out.println("Enter an amount or \'[D]one\' to print the sum and quit: ");
               newMoney = new Money(newAmount, rand);
               firstMoney = new Money(firstAmount, rand);
               sumTotal = newMoney.add(firstMoney);
               firstAmount = sumTotal.toString();
               newAmount = keyboard1.next();
               if ((newAmount.equals("D") == true)||(newAmount.equals("Done") == true)){
                  break;
               }    
         }
         System.out.println("Total: " + firstAmount);
      }
   }
} 