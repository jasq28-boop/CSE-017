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
     */
    Book(String cn, String title, int year, String author, int pages, String isbn){
        super(cn, title, year);
        this.author = author;
        this.pages = pages;
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