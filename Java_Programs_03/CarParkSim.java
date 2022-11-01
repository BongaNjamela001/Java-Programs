import java.util.Scanner;
/**
 * Write a description of class CarParkSimSolution here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarParkSim {
    
    private CarParkSim() {}


    public static void main(final String[] args) {
        
        final Scanner keyboard = new Scanner(System.in);
        final Clock clock = new Clock(new Time("00:00:00"));
        final Register register = new Register();
        
        final Currency rand = new Currency("R", "ZAR", 100);
        
        final TariffTable costTable = new TariffTable(10);
        //First tariff
        final Duration lowerBound0 = new Duration("minute", 0);
        final Duration upperBound0 = new Duration("minute",30);
        final TimePeriod interval0 = new TimePeriod(lowerBound0, upperBound0);
        final Money amount0 = new Money("R10.00", rand);
        costTable.addTariff(interval0, amount0);
        //
                
        //Second tariff
        final Duration lowerBound1 = new Duration("minute", 30);
        final Duration upperBound1 = new Duration("hour", 1);
        final TimePeriod interval1 = new TimePeriod(lowerBound1, upperBound1);
        final Money amount1 = new Money("R15.00", rand);
        costTable.addTariff(interval1, amount1);
        //
                
        //Third tariff 
        final Duration lowerBound2 = new Duration("hour", 1);
        final Duration upperBound2 = new Duration("hour", 3);
        final TimePeriod interval2 = new TimePeriod(lowerBound2, upperBound2);
        final Money amount2 = new Money("R20.00", rand);
        costTable.addTariff(interval2, amount2);
        //
                
        //Loop from fourth table entry to eigth entry
        for(long j=3; j <= 8; j++) {
           if (j == 6) {
               final Duration lowerBound3 = new Duration("hour", j);
               final Duration upperBound3 = new Duration("hour", j+2);
               final TimePeriod interval3 = new TimePeriod(lowerBound3, upperBound3);
               final Money amount3 = new Money("R"+Long.toString(j*10), rand);
               costTable.addTariff(interval3, amount3);
           }
                  
           else if (j == 7) {
               final Duration lowerBound3 = new Duration("hour", j+1);
               final Duration upperBound3 = new Duration("hour", j+3);
               final TimePeriod interval3 = new TimePeriod(lowerBound3, upperBound3);
               final Money amount3 = new Money("R"+Long.toString(j*10), rand);
               costTable.addTariff(interval3, amount3);
           }
           else if (j == 8) {
               final Duration lowerBound3 = new Duration("hour", j+2);
               final Duration upperBound3 = new Duration("hour", j+4);
               final TimePeriod interval3 = new TimePeriod(lowerBound3, upperBound3);
               final Money amount3 = new Money("R"+Long.toString(j*10+10), rand);
               costTable.addTariff(interval3, amount3);
           }

           else{
                final Duration lowerBound3 = new Duration("hour", j);
                final Duration upperBound3 = new Duration("hour", j+1);
                final TimePeriod interval3 = new TimePeriod(lowerBound3, upperBound3);
                final Money amount3 = new Money("R"+Long.toString(j*10), rand);
                costTable.addTariff(interval3, amount3);
               }
           }
           // 
                
           // Final table entry
           final Duration lowerBound4 = new Duration("hour", 12);
           final Duration upperBound4 = new Duration("day", 1);
           final TimePeriod interval4 = new TimePeriod(lowerBound4, upperBound4);
           final Money amount4 = new Money("R100.00", rand);
           costTable.addTariff(interval4, amount4);
           //
 
        
        System.out.println("Car Park Simulator");
        System.out.printf("The current time is %s.\n", clock.examine());
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();        
        
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                clock.advance(new Duration("minute", keyboard.nextInt()));  
                System.out.printf("The current time is %s.\n", clock.examine());
            }
            else if (input.equals("arrive")) {
                final Ticket ticket = new Ticket(clock.examine(), UIDGenerator.makeUID());
                register.add(ticket);
                System.out.printf("Ticket issued: %s.\n", ticket);
            }
            else if (input.equals("tariffs")) {
                System.out.println(costTable.toString());
            }
            else if (input.equals("depart")) {
                final String ID = keyboard.next();
                if (!register.contains(ID)) {
                    System.out.println("Invalid ticket ID.");
                }
                else {
                    final Ticket ticket = register.retrieve(ID);
                    System.out.printf("Ticket details: %s.\n", ticket);
                    System.out.printf("Current time: %s.\n", clock.examine());
                    final Duration durationOfStay = ticket.age(clock.examine());
                    System.out.printf("Duration of stay: %s.\n", Duration.format(durationOfStay, "minute"));
                    System.out.println("Cost of stay : " + costTable.getTariff(durationOfStay).toString() + ".");
                }
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
