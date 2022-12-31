import java.util.*;
import java.io.*;

public class Row {
    static final Scanner input = new Scanner(System.in);
    public static void main(String args[]) {

        System.out.println("Enter the start number:");

        String usernumstr = input.nextLine().trim();
        int usernumint = Integer.parseInt(usernumstr);

        if (usernumint > -6  && usernumint < 93) {
            for (int i = 0; i < 7; i++) {
                if (usernumint > -1 && usernumint <10) {
                    System.out.print(" " + usernumint + " ");
                }else{
                    System.out.print(usernumint + " ");
                }
                usernumint++;
            }
            System.out.println();
        }
    }
}