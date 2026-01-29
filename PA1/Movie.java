/**
 * Child class of title
 * Represents movies
 */
public class Movie extends Title{
    /**
     * Data members
     */
    private String director, genre;
    private int runtime;
    
    /**
     * Constructor for the movie class
     */
    Movie(String cn, String title, int year, String director, int runtime, String genre){
        super(cn, title, year);
        this.director = director;
        this.runtime = runtime;
        this.genre = genre;
    }

    /**
     * getter for director
     * @return director
     */
    public String director(){
        return this.director;
    }

    /**
     * Getter for runtime
     * @return runtime
     */
    public int runtime(){
        return this.runtime;
    }

    /**
     * getter for genre
     * @return genre
     */
    public String genre(){
        return this.genre;
    }

    /**
     * setter for director
     */
    public void setDirector(String d){
        this.director = d;
    }

    /**
     * setter for runtime
     */
    public void setRuntime(int r){
        this.runtime = r;
    }

    /**
     * setter for genre
     */
    public void setGenre(String g){
        this.genre = g;
    }

    /**
     * Overrides title class
     * Calculates late fees for a movie object
     */
    public double calculateLateFees(Date d){
        if (this.dueDate == null) return 0.0;
    
        int daysLate = d.day - this.dueDate.day;
        if (daysLate > 0) {
            return daysLate * 0.50;
        }
        return 0.0;
    }

    /**
     * Formats all attributes for movie objects
     */
    public String toString(){
        String str = super.toString() + String.format("\t%-20s\t%-5d\t%-10s", director, runtime, genre);
        return str;
    }
}