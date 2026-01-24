/**
 * Child class of Employee to model Faculty
 */
public class Faculty extends Employee{
    /**
     * Data members
     */
    String rank;

    /**
     * Default constructor
     */
    public Faculty(){
        super();
    }

    /**
     * Constructor with seven parameters
     * @param id value for id
     * @param name value for name
     * @param address value for address
     * @param phone value for phone
     * @param email value for email
     * @param position value for position
     * @param salary value for salary
     * @param rank initial value for rank
     */
    public Faculty(int id, String name, String address, String phone, String email, String position, double salary, String rank){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.salary = salary;   
        this.rank = rank;
    }

    /**
     * Acessor for rank 
     * @return rank
     */
    public String getRank(){
        return rank;
    }

    /**
     * Accessor for the faculty attributes
     * @return formatted string with the attributes
     */
    public String toString(){
        String str = super.toString() + String.format("Rank: %s\n", rank);
        return str;
    }

    /**
     * Setter for the id
     * @param rank value for rank
     */
    public void setRank(String rank){
        this.rank = rank;
    }
}