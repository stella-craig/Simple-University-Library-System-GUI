package libFunctions;

//This class tests our other classes and methods.
import java.util.*;

public class Test {

    public static void main(String[] args)
    {

        // Create the library
        Library mainStreet = new Library("Main Street Public Library", "123 main street");

        //------ Lets now hire some librarians for Main Street Public Library ------\\

        Date birthday = new Date(); // Here is everyone's birthday (it's right now)


        SSN ssn1 = new SSN(123456789);
        SSN ssn2 = new SSN(987654321); //### for some reason this ssn is invalid
        SSN ssn3 = new SSN(111111111);

        Events.hireLibrarian("Cindy", "123 First St", birthday, "cindy@gmail.com", ssn1); //### birthdays are not showing up
        Events.hireLibrarian("Martha", "123 Second St", birthday, "martha@gmail.com", ssn2);
        Events.hireLibrarian("Gertrude", "123 Third St", birthday, "gertrude@gmail.com", ssn3);


        //------ How about some technicians too ------\\

        SSN ssn4 = new SSN(888888888);
        SSN ssn5 = new SSN(999999999); //### this one is flagged as invalid too

        Events.hireTechnician("Chuck", "456 North Ave", birthday, "chuck@gmail.com", "IT", ssn4);
        Events.hireTechnician("Brock", "789 South Ave", birthday, "brock@gmail.com", "HR", ssn5);

        //------ Let's test to see if these employees have been added to the directory ------\\

        System.out.println("\n------ Here are all of the library employees ------\n");
        for(Employee e: Library.getAllEmployees()) {
            System.out.println(e);
        }

        //------ Now that we have employees, let's order some material ------\\

        Date day = new Date();

        // Here are the books
        Events.orderBook("The Scarlet Letter", "Nathaniel Hawthorne", 12.0, "Literature", 00001);
        Events.orderBook("Moby Dick", "Herman Melville", 8.0, "Literature", 00002);
        Events.orderBook("Brave New World", "Aldous Huxley", 10.0, "Literature", 00003);

        // Here are the DVDs
        Events.orderDVD("Star Wars: A New Hope", 15.0, "Sci-Fi", 00010);
        Events.orderDVD("Blues Brothers", 15.0, "Action", 00020);
        Events.orderDVD("Mama Mia", 15.0, "Music", 00030);

        // Here are the Journals
        Events.orderJournal("Chicken or the Egg?", day, 315.0, "Evolution", 00100);
        Events.orderJournal("How AI will replace everyone's jobs", day, 0.0, "Computer Science", 00200);
        Events.orderJournal("Why showering is important", day, 900.0, "Hygiene", 00300);

        // Here are the Newspapers
        Events.orderNewspaper("New York Times", day, 3.0, "News", 01000);
        Events.orderNewspaper("LA Times", day, 5.0, "News", 02000);
        Events.orderNewspaper("STL Post Dispatch", day, 0.0, "News", 03000);

        //------ Lets see if these items have hit the shelves ------\\

        System.out.println("\n\n------ Here are all of the available items at the library! ------\n");
        for(Item i: Library.getAvailableItems()) {
            System.out.println(i);
        }

        //------ With employees and items, now we can add some members ------\\

        SSN ssn11 = new SSN(121212121);
        SSN ssn12 = new SSN(232323232);
        SSN ssn13 = new SSN(343434343);
        SSN ssn14= new SSN(454545454);
        SSN ssn15 = new SSN(565656565);
        SSN ssn16 = new SSN(676767676);

        // External members
        Events.createMembership("Andrew Kruszka", "23 North St", day, "andrew@gmail.com", ssn11);
        Events.createMembership("Joe Mama", "10 West Ave", day, "joemama@gmail.com", ssn12);

        //Students
        Events.createMembership("Student 1", "3 Main st", day, "student1@gmail.com", ssn13, 000000001, 0001);
        Events.createMembership("Student 2", "4 Main st", day, "student2@gmail.com", ssn15, 000000002, 0002);

        //Professors
        Events.createMembership("Dr. Him", "25 Tiger Ave", day, "drhim@gmail.com", "Science", ssn14, 0001);
        Events.createMembership("Dr. Her", "25 Tiger Ave", day, "drher@gmail.com", "Theatre", ssn16, 0002);

        //------ Lets see if the members have correctly signed up ------\\

        System.out.println("\n\n------ Here are all the registered members ------\n");
        for(Member m: Library.getAllMembers()) {
            System.out.println(m);
        }


        //------ Checking out a book ------\\

        int memberID = Library.getAllMembers().get(2).getMemberID();
        int itemID = Library.getAvailableItems().get(3).getIsbn();
        System.out.println("\n\nMember: " + Library.getAllMembers().get(2) + "\n; Item: " + Library.getAvailableItems().get(3));
        System.out.println(itemID);

        Events.checkOut(itemID, memberID);

        /* The rest of the functionalities have been developed but not
         * yet interwoven with the other files since we all worked on different classes
         */
    }
}
