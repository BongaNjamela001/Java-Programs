import java.util.*;
import java.io.*;

public class PrintResults {
    public static void main ( String[] args ) 
    { 
        int[] weights = {1, 0, 2, 0, 1, 2, 0, 2, 2};
        String s = "";
        String n = " ";
        int h = 0, val = 0, i = 0;
        
        try ( BufferedReader br = new BufferedReader( new FileReader ("names36.txt") ) ) 
        {
            while (n != null) 
            {
                n = br.readLine();
                if (n != null) 
                {     
                     for ( i = 0; i < n.length(); i++ ) 
                     {   
                        h = weights[i]*n.charAt(i);
                        val += h;
                        System.out.println ( n.charAt(i)  + " = " + h);
                     }
                     int modulo = val % 37;
                     System.out.println( "val = " + val );
                     System.out.println(n + " (" + val + ") " + "mod 37 = " + modulo);
                     System.out.println();
                }
                h = val = 0;
            }
            br.close();
        }
        catch ( FileNotFoundException e )
        {
             e.printStackTrace();
             System.exit( 0 );
        }
        catch ( IOException oe )
        {
             oe.printStackTrace();
             System.exit(0);
        } 
    }
}
