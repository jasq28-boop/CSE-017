/**
 * Child class of title
 * Represents magazines
 */
public class Magazine extends Title{
    /**
     * Data members
     */
    private int issue, month;

    /**
     * Magazine constructor
     * Checks validity of inputted month
     */
    Magazine(String cn, String title, int year, int issue, int month){
        super(cn, title, year);
        this.issue = issue;
        
        if((month<1) || (month>12)){
            throw new IllegalArgumentException("Please enter a valid month (1-12): ");
        }
        this.month = month;
    }

    /**
     * getter for issue
     * @return issue
     */
    public int issue(){
        return this.issue;
    }

    /**
     * Getter for month
     * @return month
     */
    public int month(){
        return this.month;
    }

    /**
     * setter for issue
     */
    public void setIssue(int issue){
        this.issue = issue;
    }

    /**
     * setter for month
     */
    public void setMonth(int month){
        if((month<1) || (month>12)){
            throw new IllegalArgumentException("Please enter a valid month (1-12): ");
        }
        this.month = month;
    }

    /**
     * Formats all magazine attributes
     */
    public String toString(){
        String str = super.toString() + String.format("\t%-20s\t%-5d\t%-10d", " ", issue, month);
        return str;
    }

    /**
     * Overrides title class
     * calculates late fees for a magazine object
     * Converts the date into a total number of days
     * This gets rid of the issue of due dates in different months
     */
    public double calculateLateFees(Date d){
        if (this.dueDate == null) return 0.0;
    
        long totalDaysToday = (d.year * 360) + (d.month * 30) + d.day;
        long totalDaysDue = (this.dueDate.year * 360) + (this.dueDate.month * 30) + this.dueDate.day;
        long daysLate = totalDaysToday - totalDaysDue;

        return (daysLate > 0) ? daysLate * 0.25 : 0.0;
    }

    public String fileString(){
        return super.fileString() + "," + issue + "," + month;
    }
}