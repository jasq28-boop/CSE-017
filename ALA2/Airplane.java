import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Airplane{
    /**
     * Data members
     */
    private char[][] seatmap;

    /**
     * Default constructor for the airplane class
     * Generates a char array and fills it with .'s to represent available seats
     */
    public Airplane(){
        seatmap = new char[9][8];
        for(int i=0; i<seatmap.length; i++){
            for(int j=0; j<seatmap[i].length; j++){
                seatmap[i][j] = '.';
            }
        }
    }

    /**
     * Airplane constructor takes in a file to store the map
     */
    public Airplane(String filename){
        this();
        readMap(filename);
    }

    /**
     * Reads the seatMap from the file
     */
    private void readMap(String filename){
        try{
            Scanner read = new Scanner(new File(filename));//opens file
            for(int i=0; i<seatmap.length; i++){           //reading loop
                for(int j=0; j<seatmap[i].length; j++){
                    seatmap[i][j] = read.next().charAt(0);
                }
            }
            read.close(); //closes loop
        }
        catch(FileNotFoundException e){
        }
    }

    /**
     * Saves the finalized seatmap to a file 
     */
    public void saveMap(String filename){
        try{
            PrintWriter write = new PrintWriter(new File(filename)); //open
            
            for(int i=0; i<seatmap.length; i++){           //writing loop
                for(int j=0; j<seatmap[i].length; j++){
                    write.print(seatmap[i][j] + " ");
                }
            }

            write.close();//close
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write ot the file \"" + filename + "\"");
        }
    }

    /**
     * Checks if the provided seat number is the correct format
     */
    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException{
        if(!seatNumber.matches("[1-9][A-H]")){
            throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again.");
        }
        else{
            return true;
        }
    }

    /**
     * Changes the map to an X for the reserved seat
     */
    public boolean reserveSeat(String seatNumber) throws InvalidSeatException{
        checkSeatNumber(seatNumber);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if(seatmap[row][col] == '.'){
            seatmap[row][col] = 'X';
            return true;
        }
        return false;
    }

    /**
     * Checks if a seat is reserved or not
     * If it is the seat is freed
     */
    public boolean freeSeat(String seatNumber) throws InvalidSeatException{
        checkSeatNumber(seatNumber);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if(seatmap[row][col] == 'X'){
            seatmap[row][col] = '.';
            return true;
        }
        return false;
    }

    /**
     * Prints out the formatted map to the terminal
     */
    public String toString(){
        String output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int i=0; i<seatmap.length; i++){
            output += (i+1) + "\t";
            for(int j=0; j<seatmap[0].length; j++){
                output += seatmap[i][j] + "\t";
            }

            output += "\n";
        }
        return output;
    }
}