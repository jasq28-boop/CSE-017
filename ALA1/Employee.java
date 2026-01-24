/**
 * Child class of Person to model Employee
 */
public class Employee extends Person{
    //Data members
    String position;
    double salary;

    /**
     * Default Constructor
     */
    public Employee(){
        super();
    }

    /**
     * Constructor with seven parameters
     * @param id value for id
     * @param name value for name
     * @param address value for address
     * @param phone value for phone
     * @param email value for email
     * @param position intial value for position
     * @param salary initial value for salary
     */
    public Employee(int id, String name, String address, String phone, String email, String position, double salary){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.salary = salary;   
    }

    /**
     * Accessor for the position
     * @return position
     */
    public String getPosition(){
        return position;
    }

    /**
     * Accessor for the salary
     * @return salary
     */
    public double getSalary(){
        return salary;
    }

    /**
     * Accessor for the Employee attributes
     * @return formatted string with the object attributes
     */
    public String toString(){
        String str = super.toString() + String.format("Position: %s\nSalary: %s\n", position, salary);
        return str;
    }

    /**
     * Setter for the id
     * @param position value for position 
     */
    public void setPosition(String position){
        this.position = position;
    }

    /**
     * Setter for the salary
     * @param salary value for salary
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
}