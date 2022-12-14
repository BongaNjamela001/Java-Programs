import java.util.Scanner;
//
public class Game {

    private Game() {}
    
    public static void main(String[] inputs) {
        Scanner input = new Scanner(System.in);
        System.out.println("Your challenge is to guess a secret "+CowsAndBulls.NUM_DIGITS+" digit number.");

        System.out.println("Enter randomisation seed value:");
        CowsAndBulls cowsAndBulls = new CowsAndBulls(input.nextInt());

        System.out.println("Make a guess:");
        Result answer = cowsAndBulls.guess(input.nextInt());

        while(!answer.isCorrect()&&cowsAndBulls.guessesRemaining()>0) {

            System.out.println("Sorry that's incorrect.");
            System.out.println("You have "+answer+".");

            String status = "You have %d guess";
            if (cowsAndBulls.guessesRemaining()!=1) { status += "es"; }
            status = status+=" remaining\n";
            System.out.printf(status, cowsAndBulls.guessesRemaining());
            System.out.println("Make a guess:");
            answer = cowsAndBulls.guess(input.nextInt());
        }
        if (answer.isCorrect()) {
            System.out.println("Correct!");
         }
        else {
            System.out.println("Sorry, you lose.");
            System.out.println(cowsAndBulls.getNumber());
        }
    }
}
