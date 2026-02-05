/**
 * Title class
 * Abstract class for titles in a libray
 * Parent class of book movie and magazine
 */
public abstract class Title{
    /**
     * Data members
     */
    public String callNumber, title;
    public int year;
    public boolean checkedOut;
    public Date dueDate;

    /**
     * Constructor for Title objects
     */
    Title(String callN, String title, int year){
        if(!callN.matches("[A-Z]-\\d{6}")){
            throw new IllegalArgumentException("");
        }
        this.callNumber = callN;
        this.title = title;

        if((1900>year) || (year>java.time.Year.now().getValue())){
            throw new IllegalArgumentException("Invalid year (1900 - 2026): " + year);
        }
        this.year = year;

        this.checkedOut = false;
        this.dueDate = null;
    } 

    /**
     * Getter for callNumber
     * @return callNumber
     */
    public String callNumber(){
        return this.callNumber;
    }

    /**
     * Getter for title
     * @return title
     */
    public String title(){
        return this.title;
    }

    /**
     * Getter for year of release
     * @return year
     */
    public int year(){
        return this.year;
    }

    /**
     * getter for the dueDate
     * @return dueDate
     */
    public Date dueDate(){
        return this.dueDate;
    }

    /**
     * setter for call number
     */
    public void setCallNumber(String cn){
        this.callNumber = cn;
    }

    /**
     * Setter for title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Setter for year
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * When a title is checkout sets checkedout variable to true and sets a duedate
     */
    public void checkout(Date dueDate){
        this.checkedOut = true;
        this.dueDate = dueDate;
    }

    /**
     * Checks a title back in
     * Sets checkedOut to false and deuDate to null
     */
    public void checkin(){
        this.checkedOut = false;
        this.dueDate = null;
    }

    /**
     * Abstract method to calculatedLateFees
     */
    public abstract double  calculateLateFees(Date today);

    /**
     * Formatted output of all class attributes
     */
    public String toString() {
        return String.format("%-15s %-10s\t%-35s\t%-5d", this.getClass().getSimpleName(), callNumber, title, year);
    }

    /**
     * @return all attributes of the a Title object
     */
    public String fileString(){
        String dateStr = (dueDate == null) ? "null" : dueDate.toString();
        String cleanTitle = title.replace("\n", "").replace("\r", "");
        return this.getClass().getSimpleName() + "," + callNumber + "," + title + "," + year + "," + checkedOut + "," + dateStr;
    }
}