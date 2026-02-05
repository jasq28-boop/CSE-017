public class LibraryManager {
    public static void main(String[] args){
        // Test case 1: Creating an empty library
        Library myLibrary = new Library("Lehigh University Library");
        System.out.println("Test case 1: Creating an empty library");
        System.out.println(myLibrary.name() + " created with " + myLibrary.count() + " titles");

        // Test case 2: reading the titles from the text file
        System.out.println("\nTest case 2: Adding new titles to the library");
        myLibrary.load("titles.txt");
        System.out.println(myLibrary.name() + " has " + myLibrary.count() + " titles");

        // Test case 3: Viewing the titles
        System.out.println("\nTest case 3: Viewing all the titles in the library");
        myLibrary.all();

        // Test case 4 : Looking up titles (fail)
        System.out.println("\nTest case 4: Finding a title in the library (fail)");
        Title title = myLibrary.find("B-111111");
        if(title == null){
            System.out.println("No title found with call number B-111111");
        }
        else{
            System.out.println("Title found:");
            System.out.println(title);
        }
        // Test case 5 : Looking up titles (success)
        System.out.println("\nTest case 5: Finding a title in the library (success)");
        title = myLibrary.find("D-222222");
        if(title == null){
            System.out.println("No title found with call number D-222222");
        }
        else{
            System.out.println("Title found:");
            System.out.println(title);
        }

        // Test case 6: Removing titles (fail)
        System.out.println("\nTest case 6: Removing a title from the library (fail)");
        boolean removed = myLibrary.remove("D-222227");
        if(removed){
            System.out.println("Title with call number D-222227 found and removed successfully");
        }
        else{
            System.out.println("Title with call number D-222227 not found");
        }
        
        // Test case 7 : Removing titles (success)
        System.out.println("\nTest case 7: Removing a title from the library (success)");
        removed = myLibrary.remove("D-222222");
        if(removed){
            System.out.println("Title with call number D-222222 found and removed successfully");
        }
        else{
            System.out.println("Title with call number D-222222 not found");
        }
        System.out.println(myLibrary.name() + " has " + myLibrary.count() + " titles");
        myLibrary.all();

        // Test case 8: Checking out titles (fail)
        System.out.println("\nTest case 8: Checking out a title from the library (fail)");
        boolean checkedout = myLibrary.checkout("B-111112", new Date(1,19,2026));
        if(checkedout){
            System.out.println("Title with call number B-111112 found and checked out successfully");
        }
        else{
            System.out.println("Title with call number B-111112 not found");
        }
        
        // Test case 9: Checking out titles (success)
        System.out.println("\nTest case 9: Checking out titles from the library (success)");
        checkedout = myLibrary.checkout("B-222222", new Date(1,19,2026));
        if(checkedout){
            System.out.println("Title with call number B-222222 found and checked out successfully");
        }
        else{
            System.out.println("Title with call number B-222222 not found");
        }
        checkedout = myLibrary.checkout("D-777777", new Date(1,22,2026));
        if(checkedout){
            System.out.println("Title with call number D-777777 found and checked out successfully");
        }
        else{
            System.out.println("Title with call number D-777777 not found or already checked out");
        }
        checkedout = myLibrary.checkout("A-555555", new Date(1,28,2026));
        if(checkedout){
            System.out.println("Title with call number A-555555 found and checked out successfully");
        }
        else{
            System.out.println("Title with call number A-555555 not found");
        }
       
        // Test case 10: List of checked out titles
        System.out.println("\nTest case 10: Viewing the list of checked out titles");
        myLibrary.checkedOut();

        // Test case 11: Total late fees of late checked out titles
        System.out.println("\nTest case 11: Displaying the total late fees for overdue titles");
        myLibrary.totalLateFees(new Date(1, 30, 2026));

        // Test case 12: Returning titles (fail)
        System.out.println("\nTest case 11: Returning a title to the library (fail)");
        boolean returned = myLibrary.checkin("B-666666", new Date(1,23,2026));
        if(returned){
            System.out.println("Title with call number B-666666 checked in successfully");
        }
        else{
            System.out.println("Title with call number B-666666 not found or is not checked out");
        }
        
        // Test case 13: Returning titles (success)
        System.out.println("\nTest case 12: Returning a title to the library (success)");
        returned = myLibrary.checkin("D-555555", new Date(1,23,2026));
        if(returned){
            System.out.println("Title with call number D-555555 checked in successfully");
        }
        else{
            System.out.println("Title with call number D-555555 not found or is not checked out");
        }

        // Test case 14: save the updated titles to the file
        System.out.println("\nTest case 14: saving the titles to the file");
        myLibrary.save("titles.txt");
        System.out.println(myLibrary.count() + " titles saved to the file");

        // Test case 15: sort titles by year
        System.out.println("\nTest case 15: Sorting the library titles by year");
        myLibrary.sort();
        myLibrary.all();

        // Test case 16: loading the titles from the text file
        System.out.println("\nTest case 16: loading the titles from the text file");
        myLibrary.clear();
        myLibrary.load("titles.txt");
        System.out.println(myLibrary.name() + " has " + myLibrary.count() + " titles");

        // Test case 17: List of checked out titles
        System.out.println("\nTest case 18: Viewing the list of checked out titles");
        myLibrary.checkedOut();

        // Test case 18: Total late fees of late checked out titles
        System.out.println("\nTest case 11: Displaying the total late fees for overdue titles");
        myLibrary.totalLateFees(new Date(1, 30, 2026));

    }
}