/**
Class Ticket for issuing a unique ticket 6 digit alphanumeric
ID and entry time for pay-to-stay car parking system.
Author: Bonga Njamela
E-mail address: njmlun002@myuct.ac.za
Last Changed: September 01, 2020 
*/

import java.util.Scanner;
import java.lang.*;

public class Ticket{

   private String id;
   private Time issueTime; 
   
   /**
   Constructor is used to (i) assign the current 
   time as the ticket issue time and to (ii) assign a unique ID.
   */
   public Ticket(Time currentTime, String ID){
      this.id = ID;
      this.issueTime = currentTime;
   }
   
   /**
   Obtain this Ticket's ID.
   */
   public String ID(){
       return this.id;
   }
   
   /**
   Obtain this ticket's age i.e. the issue time subtracted from the given time.
   */
   public Duration age(Time currentTime){
      
      return new Duration(currentTime.subtract(this.issueTime));
      
   }
   
   /**
   Obtain a String representation of this Ticket object in the form:
   Ticket[id= ddddd , time= hh:mm:ss].
   */
   public String toString(){
      
      return "Ticket[id="  + this.id +  ", time="
                       + this.issueTime.toString() + "]";
   
   }
}