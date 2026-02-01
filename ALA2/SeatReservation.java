import java.util.Scanner;
import java.util.InputMismatchException;

public class SeatReservation{
    public static void main(String [] args){
        /**
         * Data members
         */
        Scanner sc = new Scanner(System.in);
        Airplane plane = new Airplane("seatmap.txt");
        int input = -1;

        /**
         * Main loop to update the seat map based on user input
         */
        do{
            System.out.println(plane.toString());
            System.out.println("Please select an operation: \n1: Reserve a seat \n2: Free a seat \n3: Quit program");
            
            /**
             * Prompots the user for a valid input number
             */
            try{
                input = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Enter an integer between 1-3.");
            }
            
            String seatNum = "";
            /**
             * The switch statement performs various operations based on the user input
             * 1 = Reserve a seat
             * 2 = Free a seat
             * 3 = quit the program
             * Runs until the user quits the program
             */
            try{
                switch(input){
                    case 1:
                        System.out.println("Enter a seat number: ");
                        seatNum = sc.next();
                        if(plane.reserveSeat(seatNum)){
                            System.out.println(seatNum + " succesfully reserved");
                        }
                        else{
                            System.out.println(seatNum + " is already reserved");
                        }
                        break;
                    case 2:
                        System.out.println("Enter a seat number: ");
                        seatNum = sc.next();
                        if(plane.freeSeat(seatNum)){
                            System.out.println(seatNum + "succesfully freed");
                        }
                        else{
                            System.out.println(seatNum + "already free");
                        }
                        break;
                    case 3:
                        plane.saveMap("seatsmap.txt");
                        break;
                    default:
                        System.out.println("Invalid operation (1-3)");
                }
            }
            catch(InvalidSeatException e){
                System.out.println(e.getMessage());
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input operation");
                sc.next();
            }
        }while(input != 3);
    }
}