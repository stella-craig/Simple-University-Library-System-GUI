package libFunctions;

//This class is a Social Security number class.
//This class is used in the member class to identify the members.
//This class retains the ssn as a String and as an Int.
//This class includes constructors and setters and getters.
//This class tests if the input ssn is a valid ssn or not.

import java.util.regex.*;

public class SSN
{
    protected String ssnString; //ssn as a string
    protected int ssnInt; //ssn as an int

    //Constructors:
    public SSN() //default constructor
    {
        this.ssnInt = 0;
        this.ssnString = null;
    }
    public SSN(int ssn)
    {
        if(!isValidSSN(String.valueOf(ssn))) //if ssn is not valid
        {
            System.out.println("Invalid ssn.");
            return;
        }

        try
        {
            this.ssnInt = ssn;
        }
        catch (NumberFormatException e) //if ssn input was not an int
        {
            System.out.println(e.getMessage());
            return;
        }

        this.ssnString = String.valueOf(ssn);
    }
    public SSN(String ssn)
    {
        if(!isValidSSN(String.valueOf(ssn))) //if ssn is not valid
        {
            System.out.println("Invalid ssn.");
            return;
        }

        this.ssnInt = Integer.parseInt(ssn);
        this.ssnString = ssn;
    }

    //Setters and Getters:
    public void setSsn(int ssn)
    {
        if(!isValidSSN(String.valueOf(ssn))) //if ssn is not valid
        {
            System.out.println("Invalid ssn.");
            return;
        }

        try
        {
            this.ssnInt = ssn;
        }
        catch (NumberFormatException e) //if ssn input is not an int
        {
            System.out.println(e.getMessage());
            return;
        }

        this.ssnString = String.valueOf(ssn);
    }
    public void setSsn(String ssn)
    {
        if(!isValidSSN(String.valueOf(ssn))) //if ssn is not valid
        {
            System.out.println("Invalid ssn.");
            return;
        }

        this.ssnInt = Integer.parseInt(ssn);
        this.ssnString = ssn;
    }
    public int getSsnInt()
    {
        return this.ssnInt;
    }
    public String getSsnString()
    {
        return this.ssnString;
    }
    public SSN getSsn()
    {
        return this;
    }

    public static boolean isValidSSN(String str)
    //function to validate ssn
    {
        //regex to check ssn
        String regex = "^(?!666|000|9\\d{2})\\d{3}"
                + "(?!00)\\d{2}"
                +"(?!0{4})\\d{4}$";

        //compile the regex
        Pattern p = Pattern.compile(regex);

        //if string is empty, return false
        if (str == null)
        {
            return false;
        }

        //method finds matching between given string and regular expression
        Matcher m = p.matcher(str);

        //return if the string matched the regex
        return m.matches();
    }
}
