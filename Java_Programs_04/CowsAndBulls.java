import java.util.Scanner;
import java.util.Arrays;
/**
 * CowsAndBulls implements the logic for a cows and bulls guessing game. The entails guessing a 4-digit
 * number.
 * 
 *
 * @author: Bonga Njamela
 * @version 24/10/20
 */
 
public class CowsAndBulls{
   
      public final static int NUM_DIGITS  =  4;
      public final static int MAX_VALUE   =  9876;
      public final static int MIN_VALUE   =  1234;
      public final static int MAX_GUESSES =  10;
      private int seed;
      private int random;
      private int guessN;
      private int guessesLeft;
      private String yes;
      /**
       * Create a CowsAndBulls game using the given randomisation seed value to generate
       * a mystery number of NUM_DIGITS length, and thaat gives the player MAX_GUESSES guesses.
       */
      public CowsAndBulls(int seed){ 
         
         this.seed = seed;
         
         final NumberPicker picker = new NumberPicker(this.seed, 1, 9);
         int i = 1;
         this.random = 0;
         while(i <= this.NUM_DIGITS){
            this.random = (this.random*10) + picker.nextInt();
            i++;
         }
         this.guessN = 1234;
         this.guessesLeft = 10;
         this.yes = " ";
      }
      
      public int getNumber(){
         return this.random;
      }
      /**
       * Obtain the number of guesses remaining.
       */
      public int guessesRemaining(){
            return this.guessesLeft;
      }
      
      /**
       * Evaluates a guess that the mystery number is guessNumber, returning the outcome
       * in the form of a Result object. Decrements guesses remaining. Assumes game is not over.
       */
      public Result guess(int guessNumber){
                  
         int bulls = NumberUtils.countMatches(this.random, guessNumber);
         int cows = NumberUtils.countIntersect(this.random, guessNumber) - bulls;
         this.guessN = guessNumber;
         this.guessesLeft = this.guessesLeft-1;
         return new Result(cows, bulls);
      }
      
      /**
       * End the game, returning the secretNumber.
       */
      public int giveUp(){
         this.yes = "yes";
         return this.random;
      }
      
      /**
       * Return true if (i) the secret number has been guessed
       * or (ii) there are no more guesses.
       */
      public boolean gameOver(){
         
         CowsAndBulls object = new CowsAndBulls(this.seed);
         if(((this.guess(this.guessN)).isCorrect())||(this.guessesLeft==0)||(this.yes=="yes")){
            return true;
         }
         return false;
      }
}