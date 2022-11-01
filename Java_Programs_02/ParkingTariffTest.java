import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ParkingTariffTest {
      
   @Test
   public void testTicketInfo(){
      
      Duration testDuration = new Duration("minute", 55);
      Duration testLowerBound = new Duration("minute", 0);
      Duration testUpperBound = new Duration("minute", 60);
      TimePeriod testTimePeriod = new TimePeriod(testLowerBound, testUpperBound);
      Currency rand = new Currency("R","ZAR", 100);
      Money testTariff = new Money("R10.00", rand);
      ParkingTariff testParking = new ParkingTariff(testTimePeriod, testTariff);
      Register testRegister = new Register();
      Time testArrival = new Time("13:05:00");
      String testID = "80000002";
      Ticket testTicket = new Ticket(testArrival, testID);
      testRegister.add(testTicket);
      testParking.cost(testDuration);
      System.out.println(testParking.ticketInfo(testRegister, testID));   
   }
}
