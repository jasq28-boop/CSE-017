/**
 * Library class
 * Stores title objects in an array
 * Allows for titles to be checked in or out
 * Can access the late fees and due dates 
 */
public class Library{
    /**
     * Data members
     */
    public Title[] titles;
    public int count;
    public String name;

    /**
     * Constructor for the library class
     * Creates titles array
     * keeps track of number of checked in entries
     */
    Library(String name){
        this.name = name;
        titles = new Title[50];
        count = 0;
    }

    /**
     * @param count getter
     */
    public int count(){
        return this.count;
    }

    /**
     * @param name getter
     */
    public String name(){
        return this.name;
    }

    /**
     * Adds files to the library
     * @return boolean 
     */
    public boolean add(Title title){
        if(titles[count] == null){
            titles[count] = title;
            count++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Finds a particular title by the call number 
     * @return the title object
     */
    public Title find(String callN){
        for(int i=0; i<count; i++){
            if (titles[i] != null) {
                if(titles[i].callNumber.equals(callN)){
                    return titles[i];
                }
            }
        }
        return null;
    }

    /**
     * Removes a title object from the library
     * @return true for succesful removal
     */
    public boolean remove(String callN){
        for(int i=0; i<count; i++){
            if(titles[i] != null){
                if(titles[i].callNumber.equals(callN)){
                    int j;
                    int k;
                    
                    for(j=i+1; j<count; j++){
                        k = j-1;
                        titles[k] = titles[j];
                    }
                    
                    titles[49] = null;
                    count--;
                    return true;
                }
            }
            
        }
        return false;
    }

    /**
     * Checks out a title by call number
     * Assigns a dueDate
     * @return true for succesful checkout
     */
    public boolean checkout(String callN, Date today){
        for(int i=0; i<count; i++){
            if(titles[i] != null){
                if(titles[i].callNumber.equals(callN)){
                    titles[i].checkout(today);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks out a title by call number
     * Checks for late fees and prints the total
     * @return true for succesful checkin
     */
    public boolean checkin(String callN, Date today){
        for(int i=0; i<count; i++){
            if(titles[i] != null){
                if(titles[i].callNumber.equals(callN)){
                    if(titles[i].checkedOut){
                        double fee = titles[i].calculateLateFees(today);
                        System.out.printf("Late fees: $%.2f\n", fee);
                        titles[i].checkin();
                        return true;
                    }
                    else{return false;}
                }
            }
        }
        return false;
    }

    /**
     * Prints all titles to the terminal
     */
    public void all(){
        for(int i=0; i<count; i++){
            if (titles[i] != null) {
                System.out.println(titles[i].toString());
            }
        }
    }

    /**
     * Prints all of the titles that are currently checked out
     */
    public void checkedOut(){
        int out = 0;
        for(int i=0; i<count; i++){
            if(titles[i].checkedOut == true){
                System.out.println(titles[i].toString());
                out++;
            }
        }

        System.out.printf("%-2d", out);
        System.out.print("title(s) are checked out of the library");
    }

    /**
     * Calculates the total late fees for every checked out title
     */
    public void totalLateFees(Date today){
        double totalFee = 0.0;
        int numOverdue = 0;
        
        for(int i=0; i<count; i++){
            if(titles[i].checkedOut && titles[i] != null){
                if(titles[i].dueDate.day < today.day){
                    totalFee += titles[i].calculateLateFees(today);
                    numOverdue++;
                }
            }
            
        }

        System.out.printf("%-2d title(s) overdue.\n", numOverdue);
        System.out.printf("Total late fees = $%.2f\n", totalFee);
    }

    /**
     * Sorts all titles in the array based on the year they were released
     */
    public void sort(){
        for (int i = 1; i < count; i++) {
            Title placeholder = titles[i];
            int currentVal = placeholder.year;
            int j = i;
            while (j > 0 && currentVal < titles[j - 1].year) {
                titles[j] = titles[j - 1];
                j--;
            }
            titles[j] = placeholder;
        }
    }
}