import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TicketTest {
   
   @Test 
   public void testTicketEntry() {
      Time t1 = new Time("13:05:25");
      Ticket newTicket = new Ticket(t1, "30A450124");
      assertEquals ("Ticket[id=" + "30A450124" 
               + ", time=" + t1.toString() + "].", newTicket.toString());
   }
               
   @Test
   public void testDurationAge() {
      Time newCurrentTime = new Time("13:05");
      Time newIssueTime = new Time("12:05");
      Duration actualDuration = newCurrentTime.subtract(newIssueTime);
      Ticket newTicket = new Ticket(newIssueTime, "29A450124");
      assertEquals (actualDuration, newTicket.age(newCurrentTime)); 
   }
}