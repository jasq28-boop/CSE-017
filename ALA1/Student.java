/**
 * Child class of Person to model Student
 */
public class Student extends Person{
    //Data members
    String major;

    /**
     * Default Constructor
     */
    public Student(){
        super();
    }

    /**
     * Constructor with six parameters
     * @param id value for id
     * @param name value for name
     * @param address value for address
     * @param phone value for phone
     * @param email value for email
     * @param major intial value for major
     */
    public Student(int id, String name, String address, String phone, String email, String major){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.major = major;
    }

    /**
     * Accessor for the major
     * @return major
     */
    public String getMajor(){
        return major;
    }

    /**
     * Accessor for the Student attributes
     * @return formatted string with the object attributes
     */
    public String toString(){
        String str = super.toString() + String.format("Major: %s\n", major);
        return str;
    }

    /**
     * Setter for the id
     * @param major value fo major 
     */
    public void setMajor(String major){
        this.major = major;
    }
}