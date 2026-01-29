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
     */
    Magazine(String cn, String title, int year, int issue, int month){
        super(cn, title, year);
        this.issue = issue;
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
     * Calculates late fees for a magazine object
     * Overrides title objects
     */
    public double calculateLateFees(Date d){
        if (this.dueDate == null) return 0.0;
    
        int daysLate = d.day - this.dueDate.day;
        if (daysLate > 0) {
            return daysLate * 0.50;
        }
        return 0.0;
    }
}