import java.util.Scanner;
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImperialMetric
{
   public static final int INCHES_PER_FOOT = 12;
   //public static final double  
   public static void main(String[] args)
   {
      double meters;
      int iterator, minFeet, maxFeet, inches, topRowEntry;
      int maxComparorVar, minComparorVar;
      Scanner keyboard = new Scanner(System.in);
      
      //Prompting for the starting feet and final feet values
      System.out.println("Enter the minimum number of feet (not less than 0):");
      minFeet = keyboard.nextInt();
      System.out.println("Enter the maximum number of feet (not more than 30):");
      maxFeet = keyboard.nextInt();
      
      //Generating feet to meters conversion table using for loop
      
      //Top inches row loop
      System.out.print("   |" + "    0\"");
      
      //Extra step to cover the case where user enters minFeet > maxFeet
      if (maxFeet < minFeet)
      {
          minComparorVar = maxFeet;
          maxComparorVar = minFeet;
      }
      else
      {
         minComparorVar = minFeet;
         maxComparorVar = maxFeet;
      }
      //End of extra step
      
      for (topRowEntry = 1; topRowEntry <= 11; topRowEntry++) 
      {
         if (topRowEntry >= 10)
            System.out.print("   " + topRowEntry + "\"");
         else 
            System.out.print("    " + topRowEntry + "\"");   
      }
      System.out.println();
      //Top inches row loop end
      
      //Table entries loop
      for (iterator = minComparorVar; iterator <= maxComparorVar; iterator++) //Row loop
      {
         if (iterator < 10)
            System.out.print(iterator + "\' | ");
         else
            System.out.print(iterator + "\'| ");
         
         for (inches = 0; inches < 12; inches++)//Column Loop
         { 
            meters = (iterator*12 + inches)*0.0254;
            System.out.printf("%5.3f ", meters);
            
         }
         System.out.println();
      }
      //Table entries loop end 
   }
}