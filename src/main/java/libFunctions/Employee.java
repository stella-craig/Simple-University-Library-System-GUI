package libFunctions;

import java.util.*;

public class Employee extends People implements Comparable<Employee>

{
    protected int empID; //employee ID
    //TODO: Should we add a hired by date? Include the person who hired them? Salary?

    //Constructors:
    public Employee()
    {
        super();
        empID = 0;
    }
    public Employee(int id)
    {
        super();
        this.empID = id;
    }
    public Employee(String name)
    {
        super(name);
        this.empID = 0;
    }
    public Employee(String name, int id)
    {
        super(name);
        this.empID = id;
    }
    public Employee(String name, String address)
    {
        super(name, address);
        this.empID = 0;
    }
    public Employee(String name, String address, int id)
    {
        super(name, address);
        this.empID = id;
    }
    public Employee(String name, String address, Date dob)
    {
        super(name, address, dob);
        this.empID = 0;
    }
    public Employee(String name, String address, Date dob, int id)
    {
        super(name, address, dob);
        this.empID = id;
    }
    public Employee(String name, String address, Date dob, String email)
    {
        super(name, address, dob, email);
        this.empID = 0;
    }
    public Employee(String name, String address, Date dob, String email, int id)
    {
        super(name, address, dob, email);
        this.empID = id;
    }
    public Employee(String name, String address, Date dob, String email, SSN ssn)
    {
        super(name, address, dob, email, ssn);
        this.empID = 0;
    }
    public Employee(String name, String address, Date dob, String email, SSN ssn, int id)
    {
        super(name, address, dob, email, ssn);
        this.empID = id;
    }
    public Employee(String name, SSN ssn)
    {
        super(name, ssn);
        this.empID = 0;
    }
    public Employee(String name, SSN ssn, int id)
    {
        super(name, ssn);
        this.empID = id;
    }
    public Employee(String name, Date dob, SSN ssn)
    {
        super(name, dob, ssn);
        this.empID = 0;
    }
    public Employee(String name, Date dob, SSN ssn, int id)
    {
        super(name, dob, ssn);
        this.empID = id;
    }

    //Setters and Getters:
    public void setEmpID(int id)
    {
        //Set the employee id to the id given.
        this.empID = id;
    }
    public int getEmpID()
    {
        //Return the employee id
        return this.empID;
    }

    @Override
    public String toString(){
        return "Employee: " + super.toString();
    }


    @Override
    public int compareTo(Employee otherEmployee){
        if(name.equalsIgnoreCase(otherEmployee.name)){
            return Integer.compare(this.empID, otherEmployee.empID);
        }else{
            return name.compareToIgnoreCase(otherEmployee.name);
        }
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Employee){
            Employee otherEmployee = (Employee) obj;
            return this.name.equalsIgnoreCase(otherEmployee.name) &&
                    this.address.equalsIgnoreCase(otherEmployee.address) &&
                    this.dob.equals(otherEmployee.dob) &&
                    this.email.equalsIgnoreCase(otherEmployee.email) &&
                    this.ssn.equals(otherEmployee.ssn) &&
                    this.empID == otherEmployee.empID;
        }else{
            return false;
        }
    }

}
