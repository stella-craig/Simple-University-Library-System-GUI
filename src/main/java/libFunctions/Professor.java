package libFunctions;

import java.util.*;

public class Professor extends Member
{
    /* TODO:
        - add university ID variable
        - can supervise many students
        - constructors
        - setters and getters
     */

    protected int uniID;
    protected String department;
    protected ArrayList<Student> supervisedStudents;

    //Constructors:
    public Professor()
    {
        super();
        uniID = 0;
    }
    public Professor(int id)
    {
        super();
        this.uniID = id;
    }
    public Professor(String name)
    {
        super(name);
        this.uniID = 0;
    }
    public Professor(String name, int id)
    {
        super(name);
        this.uniID = id;
    }
    public Professor(String name, String address)
    {
        super(name, address);
        this.uniID = 0;
    }
    public Professor(String name, String address, int id)
    {
        super(name, address);
        this.uniID = id;
    }
    public Professor(String name, String address, Date dob)
    {
        super(name, address, dob);
        this.uniID = 0;
    }
    public Professor(String name, String address, Date dob, int id)
    {
        super(name, address, dob);
        this.uniID = id;
    }
    public Professor(String name, String address, Date dob, String email)
    {
        super(name, address, dob, email);
        this.uniID = 0;
    }
    public Professor(String name, String address, Date dob, String email, int id)
    {
        super(name, address, dob, email);
        this.uniID = id;
    }
    public Professor(String name, String address, Date dob, String email, SSN ssn)
    {
        super(name, address, dob, email, ssn);
        this.uniID = 0;
    }
    public Professor(String name, String address, Date dob, String email, String department, SSN ssn, int uniid, int id)
    {
        super(name, address, dob, email, ssn, id);
        this.uniID = uniid;
        this.department = department;
    }
    public Professor(String name, SSN ssn)
    {
        super(name, ssn);
        this.uniID = 0;
    }
    public Professor(String name, SSN ssn, int id)
    {
        super(name, ssn);
        this.uniID = id;
    }
    public Professor(String name, Date dob, SSN ssn)
    {
        super(name, dob, ssn);
        this.uniID = 0;
    }
    public Professor(String name, Date dob, SSN ssn, int id)
    {
        super(name, dob, ssn);
        this.uniID = id;
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
    public void setSupervisedStudents(ArrayList<Student> arr)
    {
        //Set the array of students the professor is currently supervising
        this.supervisedStudents = arr;
    }
    public int getSupervisedStudents()
    {
        //Returns the number of students the professor is currently supervising
        return this.supervisedStudents.size();
    }
    static public int getSupervisedStudents(Professor professor)
    {
        //Returns the number of students the professor is currently supervising
        return professor.supervisedStudents.size();
    }

    public void addSupervisedStudent(int studentID)
    {
        /*
        //Add a student to the array of students the professor is currently supervising
        int n = this.supervisedStudents.length;
        //Create a new array of the previous size + 1
        Student[] new_array = new Student[n + 1];

        System.arraycopy(this.supervisedStudents, 0, new_array, 0, n);

        new_array[n] = student;
        this.setSupervisedStudents(new_array);
        */
        Student s = Events.findStudent(studentID);
        this.supervisedStudents.add(s);
    }

    public void removeSupervisedStudent(int studentID)
    {
        /*
        //Remove a student from the array of students the professor is currently supervising
        int n = this.supervisedStudents.length;

        Student[] new_array = new Student[n-1];

        int j = 0;
        for (Student supervisedStudent : this.supervisedStudents)
        {
            if (supervisedStudent == student)
            {
                break;
            }
            new_array[j] = supervisedStudent;
            j++;
        }

        this.setSupervisedStudents(new_array);
        */
        Student s = Events.findStudent(studentID);
        this.supervisedStudents.remove(s);
    }
}
