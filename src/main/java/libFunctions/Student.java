package libFunctions;

import java.util.*;

public class Student extends Member
{
    /* TODO:
        - add university ID
        - add professor ID who is supervising this student
        - constructors
        - setters and getters
     */

    protected int uniID;
    protected int profID;

    //Constructors:
    public Student()
    {
        super();
        uniID = 0;
        profID = 0;
    }
    public Student(int id, int pid)
    {
        super();
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name)
    {
        super(name);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, int id, int pid)
    {
        super(name);
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name, String address)
    {
        super(name, address);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, String address, int id, int pid)
    {
        super(name, address);
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name, String address, Date dob)
    {
        super(name, address, dob);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, String address, Date dob, int id, int pid)
    {
        super(name, address, dob);
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name, String address, Date dob, String email)
    {
        super(name, address, dob, email);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, String address, Date dob, String email, int id, int pid)
    {
        super(name, address, dob, email);
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name, String address, Date dob, String email, SSN ssn)
    {
        super(name, address, dob, email, ssn);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, String address, Date dob, String email, SSN ssn, int uniid, int pid, int memberID) // Changed to include spot for MemberID
    {
        super(name, address, dob, email, ssn, memberID);
        this.uniID = uniid;
        this.profID = pid;
    }
    public Student(String name, SSN ssn)
    {
        super(name, ssn);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, SSN ssn, int id, int pid)
    {
        super(name, ssn);
        this.uniID = id;
        this.profID = pid;
    }
    public Student(String name, Date dob, SSN ssn)
    {
        super(name, dob, ssn);
        this.uniID = 0;
        this.profID = 0;
    }
    public Student(String name, Date dob, SSN ssn, int id, int pid)
    {
        super(name, dob, ssn);
        this.uniID = id;
        this.profID = pid;
    }

    //Setters and Getters:
    public void setUniID(int id)
    {
        //Set the university id to the id given.
        this.uniID = id;
    }
    public int getUniID()
    {
        //Return the university id
        return this.uniID;
    }
    public int getMemberID()
    {
        // Return the library ID
        return super.getMemberID();
    }
    public void setProfID(int pid)
    {
        //Set the professor id to the id given.
        this.profID = pid;
    }
    public int getProfID()
    {
        //Return the professor id
        return this.profID;
    }

}