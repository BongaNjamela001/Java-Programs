/**
Register class has a register object which stores the Ticket
object which is a string of the form 
Ticket=[id="******", time="hh:mm:[ss]"] inside an array. Each
ticket can be retrieved from the array and calculate the duration
and cost.
Author: Bonga Njamela
E-mail address: njmlun002@myuct.ac.za
Last-Changed: September 04, 2020
*/

public class Register{
   
   //Construction block START
   private Ticket[] tickets;
   private int numTickets;

   public Register(){
      this.tickets = new Ticket[100];
      this.numTickets = 0;
   }
   //Construction block END
   
   /**
   The following method adds tickets to the register array 
   */
   public void add(Ticket ticket){
      
      //For loop used to check if the next
      Ticket otherArray[] = new Ticket[101];
      
      for (int i = 0; i < 100; i++){
         if (this.tickets[i] == (Ticket) null){
            this.tickets[i] = ticket;
            this.numTickets++;
            break;
         }
         else
            continue;
      }
   }
   
   /**
   The following method checks whether a ticket with the given ID 
   can be found in the register
   */
   public boolean contains(String ticketID){
      
      boolean found = true; 
      String invokedID = "";
      Ticket testTicket;
      
      for (numTickets = 0; numTickets < 100; numTickets++){
              
         testTicket = tickets[numTickets];
         invokedID = testTicket.ID();
         
         if (invokedID.equals(ticketID)){
            found = true;
            break;
         }
         else {
            found = false;
            continue;
         }
      }
      return found;
   }
   
   /**
   The following method retrieves the ticket with matching a ID 
   */
   public Ticket retrieve(String ticketID){
      
      Ticket searchTicket = new Ticket(new Time("00:00:00"), "DDDDDD");
      
      for (int i = 0; i < 100; i++){
         
         if (this.tickets[i] != (Ticket)null){
            if ((this.tickets[i]).ID().equals(ticketID))
                searchTicket = this.tickets[i];
            else
               continue;
         }
      }
      return searchTicket;
   }
}