/**
 * Child class of Title
 * Represents books
 */
public class Book extends Title{
    /**
     * Data members
     */
    private String author, isbn;
    private int pages;

    /**
     * Constructor for Book
     * Checks formatting for the isbn number
     */
    Book(String cn, String title, int year, String author, int pages, String isbn){
        super(cn, title, year);
        this.author = author;
        this.pages = pages;

        if(!isbn.matches("\\d{10}")){
            throw new IllegalArgumentException("Invalid ISBN: " + isbn);
        }
        this.isbn = isbn;
    }

    /**
     * getter for author
     * @return author
     */
    public String author(){
        return this.author;
    }

    /**
     * Getter for pages
     * @return pages
     */
    public int pages(){
        return this.pages;
    }

    /**
     * Getter for isbn
     * @return isbn
     */
    public String isbn(){
        return this.isbn;
    }

    /**
     * Setter for author
     */
    public void setAuthor(String a){
        this.author = a;
    }

    /**
     * Setter for pages
     */
    public void setPages(int p){
        this.pages = p;
    }

    /**
     * Setter for isbn
     */
    public void setIsbn(String isbn){
        if(!isbn.matches("\\d{10}")){
            throw new IllegalArgumentException("Invalid ISBN: " + isbn);
        }
        this.isbn = isbn;
    }

    /**
     * Formats all attributes for the book clas
     * Overrides title class
     */
    public String toString(){
        String str = super.toString() + String.format("\t%-20s\t%-5d\t%-10s", author, pages, isbn);
        return str;
    }

    /**
     * Overrides title class
     * calculates late fees for a book object
     * Converts the date into a total number of days
     * This gets rid of the issue of due dates in different months
     */
    public double calculateLateFees(Date d){
        if (this.dueDate == null) return 0.0;
    
        long totalDaysToday = (d.year * 360) + (d.month * 30) + d.day;
        long totalDaysDue = (this.dueDate.year * 360) + (this.dueDate.month * 30) + this.dueDate.day;
        long daysLate = totalDaysToday - totalDaysDue;

        return (daysLate > 0) ? daysLate * 0.50 : 0.0;
    }

    public String fileString(){
        return super.fileString() + "," + author + "," + pages + "," + isbn;
    }
}