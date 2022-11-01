import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class NumberUtilsTest {
   
   @Test
   public void testToArray(){
      int numberA = 1;
      int[] testvec = {1};
      int[] outputvec = NumberUtils.toArray(numberA);
      
      assertEquals (testvec, outputvec);
   }
}
