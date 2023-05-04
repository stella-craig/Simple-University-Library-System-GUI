package libFunctions;

import java.util.*;

public class DVD extends Item
{
    private String albumName;

    public DVD(String albumName, double itemPrice, String itemSection, int isbn) {
        super(itemPrice, itemSection, isbn);
        this.albumName = albumName;
    }

    public DVD(Librarian librarian, boolean ifCheckedOut, Member member, double itemPrice, String itemSection, String albumName, Date checkOutDate, int isbn) {
        super(librarian, ifCheckedOut, member, itemPrice, itemSection, checkOutDate, isbn);
        this.albumName = albumName;

    }

    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String toString()
    {
        //Return a string with all the details of this People object.
        return "DVD:" +
                " Name: " + this.albumName +
                super.toString();
    }
}

