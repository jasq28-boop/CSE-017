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
     */
    Date(int m, int d, int y){
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
        this.month = m;
    }

    /**
     * Setter for day
     */
    public void setDay(int d){
        this.day = d;
    }

    /**
     * Setter for year
     */
    public void setYear(int y){
        this.year = y;
    }

    /**
     * Formats the date
     */
    public String toString(){
        return String.format("%02d/%02d/%4d", month, day , year);
    }
}