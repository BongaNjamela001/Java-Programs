/* =====================================================
 * Title: Grid
 * Description: Accepts a number, n, where -6<n<2. The
 *              program prints out the numbers n to
 *              n+41 as 6 rows of 7 numbers. The first
 *              row will contain the values n to n+6,
 *              and the second n+7 to n+7+6 and so on.
* */

import java.util.*;
import java.io.*;

public class Grid {
    static final Scanner input = new Scanner(System.in);
    static String userInputStr = "";
    static int userInputInt = 0;
    public static void main(String[] args) {
        System.out.println("Enter the start number:");
        userInputStr = input.nextLine().trim();
        setStartNumber(userInputStr);
        printGrid();
    }

    static void setStartNumber(String userInput) {
        if (userInput != null) {
            userInputInt = Integer.parseInt(userInput);
        }
    }

    static void printGrid() {
        int num = userInputInt;
        int end = userInputInt + 41;
        int i, j, columnStart = num, columnEnd = num + 6;
        while (num < end) {
            for (i = 0; i < 7; i++) {
                    if (num > -1 && num < 10) {
                        System.out.print(" " + num + " ");
                    } else {
                        System.out.print(num + " ");
                    }
                    if (num == columnEnd) {
                        System.out.println();
                        columnStart = columnEnd + 1;
                        columnEnd = columnStart + 6;
                    }
                    num++;
            }
        }
    }
}
