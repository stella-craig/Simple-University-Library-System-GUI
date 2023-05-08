package libFunctions;

import java.util.*;

public class Newspaper extends Item
{
    private String publisher;
    private Date publishDate;

    public Newspaper(String publisher, Date publishDate, double itemPrice, String itemSection, int isbn) {
        super(itemPrice, itemSection, isbn);
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public Newspaper(Librarian librarian, boolean ifCheckedOut, Member member, double itemPrice, String itemSection, String publisher, Date checkOutDate, Date publishDate, int isbn) {
        super(librarian, ifCheckedOut, member, itemPrice, itemSection, checkOutDate, isbn);
        this.publisher = publisher;
        this.publishDate = publishDate;
    }


    /*
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    */
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String toString()
    {
        //Return a string with all the details of this People object.
        return "Newspaper:" +
                " Publisher: " + this.publisher +
                "; Publish Date: " + this.publishDate +
                super.toString();
    }


}

