public class Test{
    public static void main(String [] args){
        /**
         * Initializes array of type Person and assigns given characteristics
         */
        Person[] people = new Person[3];
        people[0] = new Student(123456789, "Paul Leister", "972 4th Street Allentown", "610-3317177","pleister@gmail.com", "CSE");
        people[1] = new Employee(334422110, "Beth Down", "234 Main Street Philadelphia", "484-222-4433", "bdown@gmail.com", "System Administrator", 75000.0);
        people[2] = new Faculty(222222222, "Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211", "mjones@gmail.com", "Faculty", 100000.0, "Associate Professor");

        /**
         * Prints out all array members and attributes randomly, sorted by name, and sorted by id
         */
        System.out.println("Original List:");
        printArray(people);

        System.out.println("Sorted by Name:");
        sortArray(people, true);
        printArray(people);

        System.out.println("Sorted by id:");
        sortArray(people, false);
        printArray(people);
    }

    public static void printArray(Person[] array){
        /**
         * Prints out all attributes of each array member
         */
        for(int i=0; i<3; i++){
            System.out.println(array[i].toString());
        }
    }

    public static void sortArray(Person[] list, boolean a){
        /**
         * Selection sort algorithm
         * Sorts by name of person
         */
        if(a == true){
            for(int i=0; i<list.length; i++){
    	        int minIndex = i;
  		        for(int j=i+1; j<list.length; j++){
        	        if((list[j].name).compareTo(list[minIndex].name) < 0){
             		    minIndex=j;
                    }
                }
  		        Person temp = list[i];
      		    list[i] = list[minIndex];
      	        list[minIndex] = temp;
    	    }
        }
        /**
         * Selection sort algorithm 
         * Sorts by ID number
         */
        else{
            for(int i=0; i<list.length; i++){
    	        int minIndex = i;
  		        for(int j=i+1; j<list.length; j++){
        	        if(list[j].id < list[minIndex].id){
             		    minIndex=j;
                    }
                }
  		        Person temp = list[i];
      		    list[i] = list[minIndex];
      	        list[minIndex] = temp;
    	    }
        }
        
    }

}