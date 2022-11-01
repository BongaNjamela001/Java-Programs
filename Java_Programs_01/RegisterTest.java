import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest{
   
   @Test
   public void testAdd(){
   
      Register testRegister = new Register();
      String testID1 = "800808";
      Time testTime1 = new Time("13:15:00");
      Ticket testTicket1 = new Ticket(testTime1, testID1);
      
      String testID2 = "80DA54";
      Time testTime2 = new Time("15:33:44");
      Ticket testTicket2 = new Ticket(testTime2, testID2);
      
      String testID3 = "80DA5406";
      Time testTime3 = new Time("14:33:44");
      Ticket testTicket3 = new Ticket(testTime3, testID3);
            
      testRegister.add(testTicket1);
      testRegister.add(testTicket2);
      testRegister.add(testTicket3);
      
      Ticket retrievedTicket1 = testRegister.retrieve(testID1);
      Ticket retrievedTicket2 = testRegister.retrieve(testID2);
      Ticket retrievedTicket3 = testRegister.retrieve(testID3);
      //System.out.println(retrievedTicket3.toString());
      //System.out.println(retrievedTicket2.toString());
      assertEquals (testTicket3.toString(), retrievedTicket3.toString());
   }
   @Test
   public void testContains(){
      
      Register testRegister = new Register();
      String testID1 = "800808";
      Time testTime1 = new Time("13:15:00");
      Ticket testTicket1 = new Ticket(testTime1, testID1);
      
      String testID2 = "80DA54";
      Time testTime2 = new Time("15:33:44");
      Ticket testTicket2 = new Ticket(testTime2, testID2);
      
      String testID3 = "80DA5406";
      Time testTime3 = new Time("14:33:44");
      Ticket testTicket3 = new Ticket(testTime3, testID3);
            
      testRegister.add(testTicket1);
      testRegister.add(testTicket2);
      testRegister.add(testTicket3);
      
      Ticket retrievedTicket1 = testRegister.retrieve(testID1);
      Ticket retrievedTicket2 = testRegister.retrieve(testID2);
      Ticket retrievedTicket3 = testRegister.retrieve(testID3);
      //System.out.println(retrievedTicket3.toString());
      //System.out.println(retrievedTicket2.toString());
      assertEquals (true, testRegister.contains("AAAAAA"));
      
   }

}