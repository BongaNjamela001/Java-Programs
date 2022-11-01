import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and Bonga Njamela...
 * @version 18/09/2020
 */
public class CarParkSim {
        
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        // YOUR CODE HERE.
        // Declare variables to store a Clock and a Register object, create the relevant objects and assign them.
        
        Time startTime = new Time("00:00:00"); //setting time to midnight
        Clock clockIn = new Clock(startTime); //constructing midnight clock
        Register ticketRegister = new Register();
        
        //END
        
        System.out.println("Car Park Simulator");
        
        // YOUR CODE HERE.
        // Print current time.
        
        Time currentTime = clockIn.examine();//value of the current time returned by examine() method in Clock class
        System.out.println("The current time is " + startTime.toString() + ".");
        
        //END
        
        System.out.println("Commands: advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                
                // YOUR CODE HERE.
                // Advance the clock, print the current time.
                
                int advanceIncrement = keyboard.nextInt();
                Duration advanceMinutes = new Duration("minutes", advanceIncrement);//time increments are in minutes 
                clockIn.advance(advanceMinutes);//incrementing the current time
                currentTime = clockIn.examine();//extracting the current time from the advanced clock
                System.out.println("The current time is " + currentTime + ".");
                                
                //END
            
            }
            else if (input.equals("arrive")) {
                // YOUR CODE HERE.
                // Create a new ticket, add it to the register, print details of ticket issued.
                
                String newID = UIDGenerator.makeUID(); // generate a ticket ID of the form 80******
                Ticket newTicket = new Ticket(currentTime, newID); //ticket is logged of form Ticket=[id=80******, time="hh:mm:ss"]
                ticketRegister.add(newTicket); //ticket is added to register
                Ticket issueTicket = ticketRegister.retrieve(newID); // use retrieve method in Ticket class to retrieve ticket from the register
                System.out.println("Ticket issued: " + issueTicket.toString() + "."); 
                
                //END
            }
            else if (input.equals("depart")) {
                // YOUR CODE HERE.
                // Determine if ticket is valid, i.e. in the register.
                // If not, print error message.
                // If yes, retreive it, calculate duration of stay and print it.
                
                String inputID = keyboard.next();
                boolean validTicket = ticketRegister.contains(inputID); //verifying that ticket is in the register
                
                if (validTicket){
                
                 Ticket userTicket = ticketRegister.retrieve(inputID);
                 Duration ticketAgeDuration = userTicket.age(currentTime);//age method uses subtract method from Duration class to find duration stayed
                 Time ticketAgeTime = new Time(ticketAgeDuration);
                 String ticketStr = userTicket.toString();       
                 System.out.println("Ticket details: " + ticketStr +".");
                 System.out.println("Current time: " + currentTime.toString() + ".");
                 System.out.println("Duration of stay: " + Duration.format(ticketAgeDuration, TimeUnit.HOUR, TimeUnit.MINUTE) + "."); 
                
                }
                else
                  System.out.println("Invalid ticket ID.");
                //END
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
