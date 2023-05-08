package libFunctions;

import java.util.*;

public class Item
{

    private Librarian librarian;
    private boolean ifCheckedOut; //true when checked out
    private Member member;
    private double itemPrice;
    private String itemSection;
    private Date checkOutDate;
    private int isbn;

    private int daysOut;

    public Item(double itemPrice, String itemSection, int isbn) {
        this.itemPrice = itemPrice;
        this.itemSection = itemSection;
        this.isbn = isbn;
        this.daysOut = 0;
    }

    public Item(Librarian librarian, boolean ifCheckedOut, Member member, double itemPrice, String itemSection, Date checkOutDate, int isbn) {
        this.librarian = librarian;
        this.ifCheckedOut = false;
        this.member = null;
        this.itemPrice = itemPrice;
        this.itemSection = itemSection;
        this.checkOutDate = null;
        this.isbn = isbn;
    }

    public boolean CheckOut(Member member, Librarian checkOutPerson) {
        if(isIfCheckedOut()) {
            return false;
        }
        setMember(member);
        setLibrarian(checkOutPerson);
        setCheckOutDate(new Date());
        int id = member.getMemberID();

        try{
            Events.checkOut(this.isbn, id);
            return true;
        }
        catch(Exception e) {
            System.out.println("Was unable to check book out");
            return false;
        }
    }

    public boolean CheckIn(Member member) {
        if(!isIfCheckedOut()) {
            return false;
        }
        setMember(null);
        setLibrarian(null);
        setCheckOutDate(null);
        int id = member.getMemberID();

        try{
            Events.returnBook(isbn, id);
            return true;
        }
        catch(Exception e) {
            System.out.println("Was unable to return book");
            return false;
        }
    }


    public int getIsbn() {
        return isbn;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemSection() {
        return itemSection;
    }
    public void setItemSection(String itemSection) {
        this.itemSection = itemSection;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public Librarian getLibrarian() {
        return librarian;
    }
    public boolean isIfCheckedOut() {
        return ifCheckedOut;
    }
    public Member getMember() {
        return member;
    }
    public void setLibrarian(Librarian librarian)
    {
        this.librarian = librarian;
    }
    public void setIfCheckedOut(boolean bool)
    {
        this.ifCheckedOut = bool;
    }
    public void setMember(Member member)
    {
        this.member = member;
    }

    public int getDaysOut() { return daysOut; }
    public void addDaysOut() { this.daysOut += 1; }
    public void resetDaysOut() { this.daysOut = 0; }

    public String toString()
    {
        //Return a string with all the details of this People object.
        return " Price: " + this.itemPrice +
                "; Genre: " + this.itemSection +
                "; ISBN: " + this.isbn;
    }

}