import java.util.InputMismatchException;

/**
 * Date class
 * Strucutre for dueDates used in the title class
 */
public class Date{
    /**
     * Data members
     */
    public int month, day, year;

    /**
     * Constructor for the date class
     * Checks that the values in the argument are valid date values
     */
    Date(int m, int d, int y){
        if((0>m) || (m>13)){
            throw new IllegalArgumentException("Month must be between 1-12");
        }
        if((0>d) ||(d>31)){
            throw new IllegalArgumentException("Day must between 1-31");
        }
        if((1900>y) || (y>java.time.Year.now().getValue())){
            throw new IllegalArgumentException("Year must be between 1900 and " + java.time.Year.now().getValue());
        }

        this.month = m;
        this.day = d;
        this.year = y;
    }

    /**
     * Getter for month
     * @return month
     */
    public int month(){
        return this.month;
    }

    /**
     * Getter for day
     * @return day
     */
    public int day(){
        return this.day;
    }

    /**
     * Getter for year
     * @return year
     */
    public int year(){
        return this.year;
    }

    /**
     * Setter for month
     */
    public void setMonth(int m){
        if((0>m) || (m>13)){
            throw new IllegalArgumentException("Month must be between 1-12");
        }
        this.month = m;
    }

    /**
     * Setter for day
     */
    public void setDay(int d){
        if((0>d) ||(d>31)){
            throw new IllegalArgumentException("Day must between 1-31");
        }
        this.day = d;
    }

    /**
     * Setter for year
     */
    public void setYear(int y){
        if((1900>y) || (y>java.time.Year.now().getValue())){
            throw new IllegalArgumentException("Year must be between 1900 and " + java.time.Year.now().getValue());
        }
        this.year = y;
    }

    /**
     * Formats the date
     */
    public String toString(){
        return String.format("%02d/%02d/%4d", month, day , year);
    }
}