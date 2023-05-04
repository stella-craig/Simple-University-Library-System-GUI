package libFunctions;

import java.util.*;

public class Book extends Item
{
    private String author;
    private String title;

    public Book(String title, String author, double itemPrice, String itemSection, int isbn) {
        super(itemPrice, itemSection, isbn);
        this.author = author;
        this.title = title;
    }

    public Book(Librarian librarian, boolean ifCheckedOut, Member member, double itemPrice, String itemSection, String author, String title, Date checkOutDate, int isbn) {
        super(librarian, ifCheckedOut, member, itemPrice, itemSection, checkOutDate, isbn);
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString()
    {
        //Return a string with all the details of this People object.
        return "Book:" +
                " Title: " + this.title +
                "; Author: " + this.author +
                super.toString();
    }

}
