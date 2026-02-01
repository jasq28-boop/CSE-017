/**
 * Defines the exception type for when an InvalidSeatNumber is entered
 */
public class InvalidSeatException extends Exception{

    public InvalidSeatException(){
        super("Invalid Seat Number");
    }

    public InvalidSeatException(String message){
        super(message);
    }
}