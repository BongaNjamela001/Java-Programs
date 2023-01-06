import java.util.*;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
public class Ships {
    static Scanner fileReader, input;
    static String fileName = "", line= "";
    static File file;
    static Boolean fileFound = false;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Enter the name of the ship data file:");
        fileName = input.nextLine().trim();
        loadFile(fileName);
        generateShips();
    }

    /*
     * Checks to see if file exists and creates a File object from
     * user input of filename.
     * @param String fileN
     */
    static void loadFile(String fileN) {
        try {
            file = new File(fileN);
            fileReader = new Scanner(new FileReader(file));
            fileFound = true;
        }catch (FileNotFoundException err) {
            fileFound = false;
            System.out.println("File Not Found");
            err.printStackTrace();
            System.exit(0);
        }
    }

    /*
     * Reads lines of the file to create data structure for handling
     * data fragments and create ships.
     */
    static void generateShips() {
        int lineNumber = 0;//max is equal to total number of lines
        String line[];
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        double a=0, b=0, c=0;
        double x=0, y=0, diff=0;
        double xi = 0, yi = 0, d1 = 0, d2 = 0;
        int des = 0, pairNum = 1; 
        double denom, xnum, ynum;
        boolean pairComplete = false;

        if (fileFound) {
            while (fileReader.hasNext()) {
              line = fileReader.nextLine().split(" ");
              if(lineNumber%2==0){
                  a = Double.parseDouble(line[0].trim());
                  b = Double.parseDouble(line[1].trim());
                  c = Double.parseDouble(line[2].trim());
                  x = Double.parseDouble(line[3].trim());
                  y = Double.parseDouble(line[4].trim());
                  des = 1;
                  ship1.setConstantAll(a,b,c,x,y,des);
//                  pair[0] = ship1;
//                  System.out.println(ship1.getString());
              }
              else {
                  a = Double.parseDouble(line[0].trim());
                  b = Double.parseDouble(line[1].trim());
                  c = Double.parseDouble(line[2].trim());
                  x = Double.parseDouble(line[3].trim());
                  y = Double.parseDouble(line[4].trim());
                  des = 2;
                  ship2.setConstantAll(a,b,c,x,y,des);
//                  pair[1] = ship2;
//                  System.out.println(ship2.getString());
                  pairComplete = true;
              }

              if (pairComplete) {
                  xnum = (ship1.getConstantB()*ship2.getConstantC()) - (ship2.getConstantB()*ship1.getConstantC());
//                  System.out.println("Ship 1 constant B1:" + ship1.getConstantB());
//                  System.out.println("Ship 2 constant C2:" + ship2.getConstantC());
//                  System.out.println(xnum);
                  ynum = (ship2.getConstantA()*ship1.getConstantC()) - (ship1.getConstantA()*ship2.getConstantC());
//                  System.out.println("Ship 2 constant A2:" + ship2.getConstantA());
//                  System.out.println("Ship 1 constant C1:" + ship1.getConstantC());
//                  System.out.println(ynum);
                  denom = (ship1.getConstantA()*ship2.getConstantB()) - (ship2.getConstantA()*ship1.getConstantB());
                  if (denom != 0 ) {
                      xi = xnum/denom;
                      yi = ynum/denom;
                  }
                  d1 = Math.sqrt(Math.pow((ship1.getConstantX() - xi),2) + Math.pow((ship1.getConstantY() - yi), 2));
                  d2 = Math.sqrt(Math.pow((ship2.getConstantX() - xi),2) + Math.pow((ship2.getConstantY() - yi), 2));
                  diff = Math.abs(d1 - d2);
                  System.out.printf(Locale.UK, "Pair %s: Intersection point: (%2.1f, %2.1f); ", pairNum, xi, yi);
                  System.out.printf(Locale.UK, "Ship S1's distance is %2.1f; ", d1);
                  System.out.printf(Locale.UK, "Ship S2's distance is %2.1f; ", d2);

                  if (diff < 0.5) {
                      System.out.println("Tied.");
                  }
                  else if (d1 < d2) {
                    System.out.println("Ship S1 is nearest.");
                  }
                  else {
                      System.out.println("Ship S2 is nearest.");
                  }
                  pairComplete = false;//clear array
//                  pair = new Ship[2];
                  pairNum++;
              }
              lineNumber++;
            }
            System.out.println("Done");
        }
    }

    /**
     * Ship object has attributes a, b, c, x, and y giving the coordinates
     * of the straight line path on which it travels. No consideration of speed of
     * ship. The equation of the Ships path is given by ax + by + c = 0
     */
}