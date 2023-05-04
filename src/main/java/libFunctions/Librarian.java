package libFunctions;

import java.util.*;

public class Librarian extends Employee
{
    /*TODO:
        - no new variables?
        - manage collections (check-in and out items)
        - help customers
        - manage memberships
     */

    public Librarian()
    {
        //Default constructor
        super();
    }

    public Librarian(String name, String address, Date dob, String email, SSN ssn, int id)
    {
        super(name, address, dob, email, ssn, id);
    }

    public void checkIn(Item item, Member member)
    {
        item.setLibrarian(this);
        item.setIfCheckedOut(false);
        item.setMember(member);
        member.removeBorrowedItem(item);
    }
}
