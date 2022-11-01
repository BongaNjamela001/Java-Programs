public class ParkingTariff{
   
   private Money amount;
   private Ticket ticket;
   private Duration duration;
   private String issueID;
   private TimePeriod classPeriod;
   
   public ParkingTariff(TimePeriod period, Money tariff){
 
      this.classPeriod = period;
      this.amount = tariff;  
   }
   
   /** Returns parking tariff's period upperbound*/
   public Duration max(){
      return this.classPeriod.upperBound();
   }
   
   /** Returns parking tariff's period lowerbound*/
   public Duration min(){
      return this.classPeriod.lowerBound();
   }
   
   /** Returns parking tariff's period*/
   public TimePeriod period(){
      return this.classPeriod;
   }
   
   /** Returns parking tariff's money amount*/
   public Money tariff(){
      return this.amount;
   }
   
   /** Returns amount as an instance of Money if the given duration
       falls within the time period
     */
   public Money cost(Duration timeOfStay){
      
      this.duration = timeOfStay;
      if ((this.classPeriod).includes(timeOfStay)){
         return this.amount;
      }
      return (Money)null;
   }

   
   /** Returns the arrival time as an instance of Time*/
   public Time arrival(){     
      
      String ticketStr = this.ticket.toString();
      String arrivalTimeStr = ticketStr.substring(ticketStr.lastIndexOf("=")+1, ticketStr.indexOf("]"));
      Time arrivalTime = new Time(arrivalTimeStr);
      return arrivalTime;
   
   }
   
   /** Returns the time of departure as an instance of Time*/
   public Time departure(){
      return this.arrival().add(this.duration);
   }
   
   /** Prints complete ticket information on departure in the following form:
     * "Ticket ID: <ticketID>.
     *  Arrival Time: <arrival time>.
     *  Departure Time: <departure time>.
     *  Cost of stay : <amount>."
     */
   public String ticketInfo(Register tickets, String ticketID){
      
      if (tickets.contains(ticketID)){
         this.ticket = tickets.retrieve(ticketID);
         String arrivalStr = this.arrival().toString();
         String departureStr = this.departure().toString();
         return "Ticket ID: " + ticketID + ".\nArrival Time: " + arrivalStr
                  + ".\nDeparture Time: " + departureStr + "\n" + this.toString();   
      }
      return "Ticket ID " + ticketID + " is invalid.";
   }   
   
   /**Returns string representation of the tariff of the form 
    * "The tariff for staying <timeOfStay> is <tariff>"
    */
   public String toString(){
      
      return "Cost of stay : " + this.amount.toString() + "."; 
                                                         
   }
}