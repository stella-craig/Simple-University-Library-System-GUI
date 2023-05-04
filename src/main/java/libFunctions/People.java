package libFunctions;

import java.util.*;

public class People
{
    protected String name;
    protected String address;
    protected Date dob; //date of birth
    protected String email;
    protected SSN ssn;  //social security number

    //Constructors:
    public People()
    {
        this.name = null;
        this.address = null;
        this.dob = null;
        this.email = null;
        this.ssn = null;
    }
    public People(String name)
    {
        this.name = name;
        this.address = null;
        this.dob = null;
        this.email = null;
        this.ssn = null;
    }
    public People(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.dob = null;
        this.email = null;
        this.ssn = null;
    }
    public People(String name, String address, Date dob)
    {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = null;
        this.ssn = null;
    }
    public People(String name, String address, Date dob, String email)
    {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.ssn = null;
    }
    public People(String name, String address, Date dob, String email, SSN ssn)
    {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.ssn = ssn;
    }
    public People(String name, SSN ssn)
    {
        this.name = name;
        this.address = null;
        this.dob = null;
        this.email = null;
        this.ssn = ssn;
    }
    public People(String name, Date dob, SSN ssn)
    {
        this.name = name;
        this.address = null;
        this.dob = dob;
        this.email = null;
        this.ssn = ssn;
    }


    public String toString()
    {
        //Return a string with all the details of this People object.
        return "Name: " + this.name +
                "; Address: " + this.address +
                "; Date of Birth: " + "" +      //TODO: add the correct formatting for the date object dob
                "; Email: " + this.email +
                "; SSN: " + this.getSSNString();
    }

    public void setName(String name)
    {
        //Set the name of this people object to the name inputted.
        this.name = name;
    }

    public void setAddress(String address)
    {
        //Set the address of this people object to the address inputted.
        this.address = address;
    }

    public void setDate(Date date)
    {
        //Set the date of birth of this people object to the date inputted.
        this.dob = date;
    }

    public void setEmail(String email)
    {
        //Set the email of this people object to the email inputted.
        this.email = email;
    }

    public void setSSN(SSN ssn)
    {
        //Set the SSN of this people object to the SSN inputted.
        this.ssn = ssn;
    }

    public String getName()
    {
        //Return the name of this people object.
        return this.name;
    }

    public String getAddress()
    {
        //Return the address of this people object.
        return this.address;
    }

    public Date getDate()
    {
        //Return the birthdate of this people object.
        return this.dob;
    }

    public String getEmail()
    {
        //Return the email of this people object.
        return this.email;
    }

    public SSN getSSN()
    {
        //Return the SSN of this people object.
        return this.ssn;
    }

    public String getSSNString()
    {
        //Return the SSN of this people object as a String.
        return this.ssn.getSsnString();
    }

    public People getPeople()
    {
        //Return the People object of this people object.
        return this;
    }

}
