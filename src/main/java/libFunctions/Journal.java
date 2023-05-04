package libFunctions;

import java.util.*;

public class Journal extends Item
{
    private Date publishDate;
    private String title;

    public Journal(String title, Date publishDate, double itemPrice, String itemSection, int isbn) {
        super(itemPrice, itemSection, isbn);
        this.publishDate = publishDate;
        this.title = title;
    }

    public Journal(Librarian librarian, boolean ifCheckedOut, Member member, double itemPrice, String itemSection, String title, Date checkoutDate, Date publishDate, int isbn) {
        super(librarian, ifCheckedOut, member, itemPrice, itemSection, checkoutDate, isbn);
        this.publishDate = publishDate;
        this.title = title;
    }

    /*
    public int getIsbn() {
        return this.isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    */

    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString()
    {
        //Return a string with all the details of this People object.
        return "Journal:" +
                " Title: " + this.title +
                "; Publish Date: " + this.publishDate +
                super.toString();
    }

}
