/* ==========================================================
 * Title: Column
 * Description: Asks user to enter a number n, where, -6<n<2.
 *              Starting from n, the program will print out
 *              every 7th number in the range n to n+41.
 * @author Bonga Njamela
 * @version 31-12-22
 * ==========================================================
 */

import java.util.*;

public class Column{

    static final Scanner input = new Scanner(System.in);
    static String userNumStr = "";
    static int userNumInt = 0;
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        userNumStr = input.nextLine().trim();
        setNumber(userNumStr);
        printColumn();
    }

    static void setNumber(String userStr) {
        if (userStr != null) {
            userNumInt = Integer.parseInt(userStr);
        }
    }

    static void printColumn() {
        int increment = userNumInt;
        int end = userNumInt + 41;
        while (increment < end) {
            if(increment > - 1 && increment < 10) {
                System.out.println(" " + increment);
            }
            else {
                System.out.println(increment);
            }
            increment += 7;
        }
    }
}