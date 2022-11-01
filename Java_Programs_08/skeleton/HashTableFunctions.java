import java.util.*;

class HashTableFunctions
{
   // hash function weights
   // 9 integers, each in the range 0-5 to act as weights for the characters in the keys
   int [] weights = {0, 2, 0, 0, 2, 2, 4, 2, 0};//{2, 2, 0, 2, 3, 0, 1, 1, 1}
   // ADD YOUR WEIGHTS INSTEAD OF 1s

   // returns True if the hash table contains string s
   // return False if the hash table does not contain string s
   boolean find ( String s, int h, int hashTableSize, String [] hashTableArray )
   {	
       int hashTableIndex;
       int count = 0;
       for ( hashTableIndex = 0; hashTableIndex < hashTableSize; hashTableIndex++ ) 
       {
            if (s.equalsIgnoreCase(hashTableArray[hashTableIndex]))
                count++;
       }
       
       if ( count > 0 ) 
           return true;
       
       return false;
   }
   
//    int [] weigh () {
//        
//        int[] w = {0, 1, 1, 0, 1, 0, 3, 2, 1};
//        int k = 0, r = 0;
//        Random rand = new Random();
//        
//        for (k = 1; k < 9; k ++) 
//        {	
//            r = rand.nextInt(5);
//            if (r != 0)
//                  w[k] = (int) r%5;
//        }
//        return w;
//    }
}
