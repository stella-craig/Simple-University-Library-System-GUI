package libFunctions;

import java.util.*;

public class Member extends People
{
    protected int memberID;
    protected ArrayList<Item> borrowedItems;
    protected int fineTotal;

    //Constructors:
    public Member()
    {
        super();
        memberID = 0;
    }
    public Member(int id)
    {
        super();
        this.memberID = id;
    }
    public Member(String name)
    {
        super(name);
        this.memberID = 0;
    }
    public Member(String name, int id)
    {
        super(name);
        this.memberID = id;
    }
    public Member(String name, String address)
    {
        super(name, address);
        this.memberID = 0;
    }
    public Member(String name, String address, int id)
    {
        super(name, address);
        this.memberID = id;
    }
    public Member(String name, String address, Date dob)
    {
        super(name, address, dob);
        this.memberID = 0;
    }
    public Member(String name, String address, Date dob, int id)
    {
        super(name, address, dob);
        this.memberID = id;
    }
    public Member(String name, String address, Date dob, String email)
    {
        super(name, address, dob, email);
        this.memberID = 0;
    }
    public Member(String name, String address, Date dob, String email, int id)
    {
        super(name, address, dob, email);
        this.memberID = id;
    }
    public Member(String name, String address, Date dob, String email, SSN ssn)
    {
        super(name, address, dob, email, ssn);
        this.memberID = 0;
    }
    public Member(String name, String address, Date dob, String email, SSN ssn, int id)
    {
        super(name, address, dob, email, ssn);
        this.memberID = id;
        this.borrowedItems = new ArrayList<Item>();
    }
    public Member(String name, SSN ssn)
    {
        super(name, ssn);
        this.memberID = 0;
    }
    public Member(String name, SSN ssn, int id)
    {
        super(name, ssn);
        this.memberID = id;
    }
    public Member(String name, Date dob, SSN ssn)
    {
        super(name, dob, ssn);
        this.memberID = 0;
    }
    public Member(String name, Date dob, SSN ssn, int id)
    {
        super(name, dob, ssn);
        this.memberID = id;
    }

    //Setters and Getters:
    public void setMemberID(int id)
    {
        //Set the member id to the id given.
        this.memberID = id;
    }
    public int getMemberID()
    {
        //Return the member id
        return this.memberID;
    }

    public void setFineTotal(int fine)
    {
        //Set fine total
        this.fineTotal = fine;
    }
    public int getFineTotal()
    {
        //Return fine total
        return this.fineTotal;
    }
    public void addFine(int fine)
    {
        //Add to fine total
        this.fineTotal = this.fineTotal + fine;
    }
    public void subtractFine(int fine)
    {
        //Subtract from fine total
        this.fineTotal = this.fineTotal - fine;
    }
    public void setBorrowedItems(ArrayList<Item> arr)
    {
        //Set the array of items the member is currently borrowing
        this.borrowedItems = arr;
    }
    public ArrayList<Item> getBorrowedItems()
    {
        return this.borrowedItems;
    }
    public void addBorrowedItem(Item item)
    {
        /*
        //Add an item to the array of items the member is currently borrowing
        int n = this.borrowedItems.length;
        //Create a new array of the previous size + 1
        Item[] new_array = new Item[n + 1];

        System.arraycopy(this.borrowedItems, 0, new_array, 0, n);

        new_array[n] = item;
        this.setBorrowedItems(new_array);
        */
        this.borrowedItems.add(item);
    }

    public void removeBorrowedItem(Item item)
    {
        /*
        //Remove an item from the array of items the member is currently borrowing
        int n = this.borrowedItems.length;

        Item[] new_array = new Item[n-1];

        int j = 0;
        for (Item borrowedItem : this.borrowedItems)
        {
            if (borrowedItem == item)
            {
                break;
            }
            new_array[j] = borrowedItem;
            j++;
        }

        this.setBorrowedItems(new_array);
        */
        this.borrowedItems.remove(item);
    }

    public int getNumberBorrowed()
    {
        //Returns the number of items the member has currently checked out
        //Note that a member should not have more than 5 items checked out
        return this.borrowedItems.size();
    }
    static public int getNumberBorrowed(Member member)
    {
        //Returns the number of items the member has currently checked out
        //Note that a member should not have more than 5 items checked out
        return member.borrowedItems.size();
    }
}
