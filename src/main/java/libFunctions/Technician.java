package libFunctions;

import java.util.*;

public class Technician extends Employee
{
    /* TODO:
        - no new variables?
        - sort returned books
        - re-shelve in correct location
        - constructors
        - setters and getters?
     */
    private String department;

    public Technician(String name, String address, Date dob, String email, String department, SSN ssn, int id) {

        super(name, address, dob, email, ssn, id);
        this.department = department;

    }
}
