/*
 * ====================================================================
 * Title: 30 Second Rule Expert
 *
 * Description: Program asks a series of questions to determine
 *              if the user should eat food that fell on the ground.
 *
 * @author UCT CSC2004Z + NJMLUN002
 * @version 30-12-2022
 * ====================================================================
 */
import java.util.Scanner;

public class Cupcake {

    public static void main(final String[] args) {
        // Program introduction prompt
        final Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the 30 Second Rule Expert");
        System.out.println("------------------------------------");
        System.out.println("Answer the following questions by selecting from among the options.");

        //Prompt user and scan input after they drop their food
        System.out.println("Did anyone see you? (yes/no)");
        String r = input.nextLine().trim().toLowerCase();
        String decision = "Error";
        //main branch (see-you branch) : first-level
        if (r.equals("no")) {
            System.out.println("Was it sticky? (yes/no)");
            r = input.nextLine().trim().toLowerCase();
            // stick sub-branch : second-level
            if (r.equals("no")) {
                System.out.println("Is it an Emausaurus? (yes/no)");
                r = input.nextLine().trim().toLowerCase();
                // emausaurus sub-sub-branch : third-level
                if (r.equals("no")) {
                    System.out.println("Did the cat lick it? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    // cat-lick sub-sub-sub-branch: fourth-level
                    if (r.equals("no")) {
                        decision = "Eat it.";
                    } else {
                        System.out.println("Is your cat healthy? (yes/no)");
                        r = input.nextLine().trim().toLowerCase();
                        // cat-health sub-sub-sub-sub-branch : final-level
                        if (r.equals("no")) {
                            decision = "Your call.";
                        } else {
                            decision = "Eat it.";
                        }
                    }
                } else { // not emausaurus sub-sub-branch : third-level
                    System.out.println("Are you a Megalosaurus? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    // megalosaurus sub-sub-sub-branch : fourth-level
                    if (r.equals("no")) {
                        decision = "Don't eat it.";
                    } else {
                        decision = "Eat it.";
                    }
                }
            }
            //not sticky sub-branch: second-level
            else {
                System.out.println("Is it a raw steak? (yes/no)");
                r = input.nextLine().trim().toLowerCase();
                //raw-steak sub-sub-branch: third-level
                if (r.equals("no")) {
                    System.out.println("Did the cat lick it? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    // cat-lick sub-sub-sub-branch: fourth-level
                    if (r.equals("no")) {
                        decision = "Eat it.";
                    }else {
                        System.out.println("Is your cat healthy? (yes/no)");
                        r = input.nextLine().trim().toLowerCase();
                        // cat-health sub-sub-sub-sub-branch: final-level
                        if (r.equals("no")) {
                            decision = "Your call.";
                        } else {
                            decision = "Eat it.";
                        }
                    }
                }
                else { //not raw-steak sub-sub-branch: third-level
                    System.out.println("Are you a puma? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    //puma sub-sub-sub-branch: fourth level
                    if (r.equals("no")) {
                        decision = "Don't eat it.";
                    } else {
                        decision = "Eat it.";
                    }//4th-level
                }//3rd level
            }//2nd level
        }//1st level
        else {//someone saw branch : first level
            System.out.println("Was it a boss/lover/parent? (yes/no)");
            r = input.nextLine().trim().toLowerCase();
            if (r.equals("no")) {
                decision = "Eat it.";
            }
            else {
                System.out.println("Was it expensive? (yes/no)");
                r = input.nextLine().trim().toLowerCase();
                if (r.equals("no")) {
                    System.out.println("Is it chocolate? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    if (r.equals("no")) {
                        decision = "Don't eat it.";
                    } else {
                        decision = "Eat it.";
                    }
                } else {
                    System.out.println("Can you cut off the part that touched the floor? (yes/no)");
                    r = input.nextLine().trim().toLowerCase();
                    if (r.equals("no")) {
                        decision = "Your call.";
                    } else {
                        decision = "Eat it.";
                    }
                }
            }
        }
        System.out.printf("Decision: %s\n",decision);

    }
}
