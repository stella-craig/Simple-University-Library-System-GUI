package libFunctions;

import java.util.ArrayList;

public class Library {

    private String name;
    private String address;

    protected static ArrayList<Item> availableItems;
    protected static ArrayList<Item> holdItems;
    protected static ArrayList<Member> allMembers;
    protected static ArrayList<Employee> allEmployees;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        availableItems = new ArrayList<Item>();
        holdItems = new ArrayList<Item>();
        allMembers = new ArrayList<Member>();
        allEmployees = new ArrayList<Employee>();
    }

    /* Keeps track of all the library stuff:
     * Array of books, dvds, etc
     * Array of all employees
     * Array of all members
     * Array of checked out items
     * Array of items on hold
     * Array of available items
     * Array of lost items
     * Etc
     */

    public String getName() {
        return(this.name);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return(this.address);
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public static ArrayList<Item> getAvailableItems() {

        return(availableItems);
    }

    public static ArrayList<Item> getHoldItems() {

        return(holdItems);
    }

    public static ArrayList<Member> getAllMembers() {

        return(allMembers);
    }

    public static ArrayList<Employee> getAllEmployees() {

        return(allEmployees);
    }

    public static void addAvailableItems(Item item) {


    }
}
