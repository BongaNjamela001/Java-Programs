import java.util.Scanner;
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class TimeConvertor
{
   public static void main(String[] args)
   {
      String timeStr, actualTime, twelveHourFormat, afterEightPm; //declaring user input variable for time 
      char firstNumberOnClock;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter a time ([h]h:mm [am|pm]):");
      timeStr = keyboard.nextLine();
            
      actualTime = timeStr.trim();//extracting actual time
      int mPosition = timeStr.indexOf("m");
      twelveHourFormat = actualTime.substring(1);
      firstNumberOnClock = actualTime.charAt(0);

      //The following if statements convert the 24hr format to a 12hr one
      
      if (mPosition == -1) // If there is no am or pm in the entered time, i.e. user entered 24hr format 
      {         
         if (firstNumberOnClock == '0') //Checking if the first number in the clock is zero
         {   
            if (actualTime.charAt(1) != '0')
               System.out.println(twelveHourFormat + " am");
            else
               System.out.println("12" + actualTime.substring(2) + " am");
         }
         else if (firstNumberOnClock == '2') //Checking if the second number is a 2 for times after 8 pm
         {
            if (actualTime.charAt(1) == '0')
               System.out.print("8" + actualTime.substring(2, actualTime.length()) + " pm");
            else if (actualTime.charAt(1) == '1')         
               System.out.print("9" + actualTime.substring(2) + " pm");
            else if (actualTime.charAt(1) == '2')         
               System.out.print("10" + actualTime.substring(2) + " pm");
            else if (actualTime.charAt(1) == '3')         
               System.out.print("11" + actualTime.substring(2) + " pm");
         }
         if (firstNumberOnClock == '1') //Checking if the second number is a 1
         {    
               if (actualTime.charAt(1) == '2')
                  System.out.print("12" + actualTime.substring(2) + " pm");
               else if (actualTime.charAt(1) != '2')
                  if (actualTime.charAt(1) == '3')
                     System.out.print("1" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '4')
                     System.out.print("2" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '5')
                     System.out.print("3" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '6')
                     System.out.print("4" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '7')
                     System.out.print("5" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '8')
                     System.out.print("6" + actualTime.substring(2) + " pm");
                  else if (actualTime.charAt(1) == '9')
                     System.out.print("7" + actualTime.substring(2) + " pm");
               else if (actualTime.charAt(1) == '0')
                    System.out.print("10" + actualTime.substring(2) + " am");
               else if (actualTime.charAt(1) == '1')
                    System.out.print("11" + actualTime.substring(2) + " am");
         }
      
      }
      //The following if statements convert from the 12Hr to 24Hr format
      
      else
      {
         if (timeStr.charAt(timeStr.indexOf("m")-1) == 'a')//Checking if we have am
            if ((firstNumberOnClock == '1') && (actualTime.charAt(1) == ':'))//Checking if the time is 1:XX am
               System.out.print("01" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '2')
               System.out.print("02" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '3')
               System.out.print("03" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '4')
               System.out.print("04" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '5')
               System.out.print("05" + actualTime.substring(1,4));   
            else if (firstNumberOnClock == '6')
               System.out.print("06" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '7')
               System.out.print("07" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '8')
               System.out.print("08" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '9')
               System.out.print("09" + actualTime.substring(1,4));
            
            else if ((firstNumberOnClock == '1') && (actualTime.charAt(1) != ':'))//Checking if time is 1X:XX am 
               if (actualTime.charAt(1) == '0')
                  System.out.print("10" + actualTime.substring(2,5));
               else if (actualTime.charAt(1) == '1')
                  System.out.print("11" + actualTime.substring(2,5));
               else if (actualTime.charAt(1) == '2')
                  System.out.print("00" + actualTime.substring(2,5));             
                  
         if (timeStr.charAt(timeStr.indexOf("m")-1) == 'p')//Checking if we have pm
            if ((firstNumberOnClock == '1') && (actualTime.charAt(1) == ':'))//Checking if the time is 1:XX am
               System.out.print("13" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '2')
               System.out.print("14" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '3')
               System.out.print("15" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '4')
               System.out.print("16" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '5')
               System.out.print("17" + actualTime.substring(1,4));   
            else if (firstNumberOnClock == '6')
               System.out.print("18" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '7')
               System.out.print("19" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '8')
               System.out.print("20" + actualTime.substring(1,4));
            else if (firstNumberOnClock == '9')
               System.out.print("21" + actualTime.substring(1,4));
            
            else if ((firstNumberOnClock == '1') && (actualTime.charAt(1) != ':'))//Checking if time is 1X:XX am 
               if (actualTime.charAt(1) == '0')
                  System.out.print("22" + actualTime.substring(2,5));
               else if (actualTime.charAt(1) == '1')
                  System.out.print("23" + actualTime.substring(2,5));
               else if (actualTime.charAt(1) == '2')
                  System.out.print("12" + actualTime.substring(2,5));             
       }                   
   }
}