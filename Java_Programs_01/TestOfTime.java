/**
JUnit tests the Time and Duration classes for the
the pay-to-stay car parking system 
Author: Bonga Njamela
E-mail address: njmlun002@myuct.ac.za
Last Changed: September 01, 2020 
*/
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestOfTime {
   /**
   Following tests that a Time object actually stores the time
   value provided as a parameter during creation by calling toString method
   */
   @Test
   public void testTimeObjectInput(){
      
      String providedTimeStr = "23:59:59";
      Time providedTime = new Time(providedTimeStr);
      providedTime.getHours();
      providedTime.getMinutes();
      providedTime.getSeconds();
      assertEquals (providedTimeStr, providedTimeStr.toString());           
   }
   
   /**
   Tests that subtracting an earlier Time from a later Time 
   produces a Duration of the correct length.
   */
   @Test
   public void testDurationOutput(){
      
      String earlierTimeStr = "10:04:23";
      String laterTimeStr = "12:15:47";
      Time earlierTimeOb = new Time(earlierTimeStr);
      Time laterTimeOb = new Time(laterTimeStr);
      Duration durationTimeOb = laterTimeOb.subtract(earlierTimeOb);
      assertEquals (15, durationTimeOb.toString().length());
   }
   
   /**
   Check that subtracting a Time from 
   itself produces a zero Duration.
   */
   @Test
   public void testZeroDuration(){
      
      Time time1 = new Time("16:06:47");
      Time time2 = new Time("16:06:47");
      Duration actualDuration = time1.subtract(time2);
      assertEquals (0, actualDuration.intValue("minute"), 0.001);    
   }
   
   /**
   Check that the intValue method works 
   with a parameter of millisecond.
   */
   @Test
   public void testMillisecondDurationUnit(){
      
      Duration createdDuration = new Duration("second", 2);
      assertEquals (2000, createdDuration.intValue("millisecond"), 0.001);
   }
   
   /**
   Check that the intValue method 
   works with a parameter of second.
   */
   @Test
   public void testSecondDurationUnit(){
      
      Duration createdDuration = new Duration("minute", 20);
      assertEquals (1200, createdDuration.intValue("second"), 60);
   }
   
   /**
   Check that the intValue method works with a
   parameter of minute.
   */
   @Test
   public void testMinuteDurationUnit(){
      
      Duration createdDuration = new Duration("hour", 50);
      assertEquals (3000, createdDuration.intValue("minute"), 60);
   }
   
   /**
   Check that the intValue method works with a 
   parameter of hour.
   */
   @Test
   public void testHourDurationUnit(){
      
      Duration createdDuration = new Duration("minute", 124);
      assertEquals (2, createdDuration.intValue("hour"), 60);
   }

}
