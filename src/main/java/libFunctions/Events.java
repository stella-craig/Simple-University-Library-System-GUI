package libFunctions;

import java.util.*;


public final class Events {

    static ArrayList<Item> availableItems = Library.getAvailableItems();
    static ArrayList<Item> holdItems = Library.getHoldItems();
    static ArrayList<Member> allMembers = Library.getAllMembers();

    //----------------These methods should call functions from the other classes----------------\\

    public static Member findMember(int memberID) {

        for(Member m: allMembers) {
            if(m.getMemberID() == memberID){
                return(m);
            }
        }
        System.out.println("There is no member with that ID");
        return(null);
    }

    public static Student findStudent(int studentID) {

        Member s = findMember(studentID);
        return((Student)s);
    }

    // Checks if an item is on hold
    //
    public static boolean checkHold(int itemID) {

        for(Item i: holdItems) {
            if(i.getIsbn() == itemID) {
                System.out.println("Item is on hold");
                return(true);
            }
        }

        return(false);
    }

    // Gets the item and calls the Member method addBorrowedItem
    //
    public static void addToUserBooks(Item item, int memberID) {

        Member m = findMember(memberID);
        if(m != null){
            m.addBorrowedItem(item);
            System.out.println("Book was added to " + m.getName() + "'s account");
            Library.addAvailableItems(item);
        }
        else{
            System.out.println("Method addToUserBooks did not work since the member ID was invalid");
        }
    }

    // Removes the item from the set of available items at the library
    // Assigns the item to the member who checked it out and creates a due date
    //
    public static void checkOut(int itemID, int memberID) {

        Item item;

        // 1. Check to see if the book is in the array of available library items
        for(Item i: availableItems) { // Iterate through arraylist of all items
            if(i.getIsbn() == itemID) { // Find the specific item
                System.out.println("Item has been located");
                if(!checkHold(i.getIsbn())) { // If the item is not in the hold array
                    item = (Item)i;
                    System.out.println("That item is available to check out");
                    addToUserBooks(item, memberID); // 3. Add the book ID into the array of books checked out by memberID
                    availableItems.remove(i); // 4. Remove the book from the array of available libraray books
                    Library.holdItems.add(i);
                    break;
                }

                else{ // If item is on hold or checked out
                    System.out.println("That item is not available to check out");
                    break;
                }
            }
        }
    }

    // Creates a new due date for the book
    //
    public static void renewBook(int bookID, int memberID) {

        // 1. Check to see if the book is in the array of books checked out by the member
        Member m = findMember(memberID);

        for(Item i : m.getBorrowedItems()) {
            if(i.getIsbn() == bookID) {
                // 2. Check to see that the book is not overdue (if overdue, cannot be renewed)

                for(Item h: Library.getHoldItems()) { // 3. Check to see if the book has been reserved by another member
                    if(h.getIsbn() == i.getIsbn()) {
                        System.out.println("Cannot renew item, it is on hold by another member");
                        break;
                    }

                    // 4. Reset the return timer to 14 days
                }
            }
        }
    }

    // Adds the book into the set of available books at the library
    // Removes the book from the member who checked it out
    //
    public static void returnBook(int bookID, int memberID) {

        Member m = findMember(memberID);
        // 1. Check to see if the book is in the array of books checked out by the member
        if(m != null) {
            for(Item i: m.getBorrowedItems()) {
                if(i.getIsbn() == bookID) {
                    m.removeBorrowedItem(i); // 2. Remove the book from the array of books checked out by the member

                }
                else {
                    System.out.println("This member did not check that book out");
                    break;
                }
            }
        }
    }

    // Creates a new External object
    public static External createMembership(String name, String address, Date dob, String email, SSN ssn) {

        // 1. Create a new memberID
        Random rand = new Random();
        int upper = 1000000000;

        int id = rand.nextInt(upper);

        // 2. Call the External constructor and add to library member array
        External external = new External(name, address, dob, email, ssn, id);
        Library.allMembers.add(external);
        // 3. Return the External object
        return(external);
    }

    // Creates a new Student object
    public static Student createMembership(String name, String address, Date dob, String email, SSN ssn, int uniid, int pid) {

        // 1. Create a new memberID
        Random rand = new Random();
        int upper = 1000000000;

        int id = rand.nextInt(upper);

        // 2. Call the Student constructor and add to library member array
        Student student = new Student(name, address, dob, email, ssn, uniid, pid, id);
        Library.allMembers.add(student);
        // 3. Return the External object
        return(student);
    }

    // Creates a new Professor object
    public static Professor createMembership(String name, String address, Date dob, String email, String department, SSN ssn, int uniid) {

        // 1. Create a new memberID
        Random rand = new Random();
        int upper = 1000000000;

        int id = rand.nextInt(upper);

        // 2. Call the Student constructor and add to library member array
        Professor professor = new Professor(name, address, dob, email, department, ssn, uniid, id);
        Library.allMembers.add(professor);
        // 3. Return the External object
        return(professor);
    }

    // Creates a new Librarian object
    public static Librarian hireLibrarian(String name, String address, Date dob, String email, SSN ssn) {

        // 1. Create a new employee ID
        Random rand = new Random();
        int upper = 1000000000;

        int id = rand.nextInt(upper);
        // 3. Call the Librarian constructor and add to library employee array
        Librarian librarian = new Librarian(name, address, dob, email, ssn, id);
        Library.allEmployees.add(librarian);
        // 4. Return the Librarian object
        return(librarian);
    }

    // Creates a new Technician object
    public static Technician hireTechnician(String name, String address, Date dob, String email, String department, SSN ssn) {

        // 1. Create a new employee ID
        Random rand = new Random();
        int upper = 1000000000;

        int id = rand.nextInt(upper);
        // 3. Call the Technician constructor and add to library employee array
        Technician technician = new Technician(name, address, dob, email, department, ssn, id);
        Library.allEmployees.add(technician);
        // 4. Return the Librarian object
        return(technician);
    }


    // Order a book
    public static Book orderBook(String title, String author, double itemPrice, String itemSection, int isbn) {
        //1. Call the book constructor and add to available items array
        Book book = new Book(title, author, itemPrice, itemSection, isbn);
        Library.availableItems.add(book);

        return(book);
    }

    // Order a DVD
    public static DVD orderDVD(String albumName, double itemPrice, String itemSection, int isbn) {
        //1. Call the dvd constructor and add to available items array
        DVD dvd = new DVD(albumName, itemPrice, itemSection, isbn);
        Library.availableItems.add(dvd);

        return(dvd);
    }


    // Order a Journal
    public static Journal orderJournal(String title, Date publishDate, double itemPrice, String itemSection, int isbn) {
        // 1. Call the journal constructor and add to available items array
        Journal journal = new Journal(title, publishDate, itemPrice, itemSection, isbn);
        Library.availableItems.add(journal);

        return(journal);
    }


    // Order a Newspaper
    public static Newspaper orderNewspaper(String publisher, Date publishDate, double itemPrice, String itemSection, int isbn) {
        // 1. Call the newspaper constructor and add to available items array
        Newspaper newspaper = new Newspaper(publisher, publishDate, itemPrice, itemSection, isbn);
        Library.availableItems.add(newspaper);

        return(newspaper);
    }









    ///////////////TIMER METHODS\\\\\\\\\\\\\\\

    // Reminds the member that the material is due in 2 days
    public static void firstReminder() {

        // 1. Check list of checked out books for books that have been out for 12 days
        // 2. Send message to inbox of memberID associated with those books

        // Message states that the book is due in 2 days if it is not renewed

    }

    // Reminds the member that the material is due that day
    public static void secondReminder() {

        // 1. Check list of checked out books for books that have been out 14 days
        // 2. Send message to inbox of the memberID associated with those books

        /* Message states that the book is due that day, can no longer renew, and that a
            1$ fine will be charged to the members account for every day the book is not returned*/

    }

    // A $1 fine is added to the member's account each day after 14 days
    public static void thirdReminder() {

        // 1. Check list of checked out books for books that have been out 15+ days
        // 2. Aggregate a $1 fine for each day the book has been out past 14 days

    }

    // Another email is sent to the member and a letter is mailed to the member address
    public static void fourthReminder() {

        // 1. Check list of checked out books for books that have been out for 28 days
        // 2. Send a message to the inbox of the memberID associated with those books

        /* Message includes that a $14 fine has been added to the account and a
            physical mail has been sent to the address */


    }

    // The book is declared lost and full price is charged to the member in addition to the fines
    public static void itemLost() {

        // 1. Check list of checked out books for books that have been out for 30 days
        // 2. Remove the book from the library catalog and from the checked out books
        // 3. Charge the member's account the full price of the book

    }

    // The book is declared lost and full price is charged to the member in addition to the fines
    // This method is for when a member declares they lost the book
    public static void itemLost(int memberID) {

        // 1. Remove the book from the libraray catalog and from the checked out books
        // 2. Charge the member's account the full price of the book

    }


}
