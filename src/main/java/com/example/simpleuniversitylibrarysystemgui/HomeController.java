package com.example.simpleuniversitylibrarysystemgui;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import libFunctions.*;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.*;

public class HomeController {


    //This section of code just makes all the buttons on the main page work.
    @FXML
    protected void onNewMembershipButtonClick() throws IOException {
        //This open the new membership window
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("newMember.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New-Member");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onNewCollectionButtonClick() throws IOException {
        //This opens the new collection window
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("newItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New-Collection");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onRemoveMembershipButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("removeMember.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Remove-Membership");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onRemoveItemButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("removeItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Remove-Item");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onNewEmployeeButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("newEmployee.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New-Employee");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onBorrowItemButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("checkoutItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Borrow-Item");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onReturnItemButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("returnItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Return-Item");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onCheckOverduesButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("checkOverdue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Check-Overdue");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onEditInformationButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("editInformation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Edit-Information");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }



    //The following code is for the all fxml files
    @FXML    TextField nameBox;
    @FXML    TextField emailBox;
    @FXML    TextField SSNBox;
    @FXML    TextArea addressBox;
    @FXML    TextField titleBox;
    @FXML    TextField authorBox;
    @FXML    TextField ISBNBox;
    @FXML    TextField genreBox;
    @FXML    TextField priceBox;
    @FXML    TextField addressBoxField;
    @FXML    TextField idBox;
    @FXML    DatePicker DoBBox;
    @FXML    Label errorMessage;
    @FXML    CheckBox CBStudent;
    @FXML    CheckBox CBProfessor;
    @FXML    CheckBox CBExternal;
    @FXML    RadioButton RLibrarian;
    @FXML    RadioButton RTechnician;
    @FXML    RadioButton RBook;
    @FXML    RadioButton RDVD;
    @FXML    RadioButton RJournal;
    @FXML    RadioButton RNewspaper;
    @FXML    TextField NSStuID;
    @FXML    TextField NSProfID;
    @FXML    Button submit;
    @FXML    Button cancel;
    @FXML    TableColumn<Member, String> typeColumn;

    //Helper functions for the different page functions

    // Check if there are empty string fields
    protected boolean checkEmptyStringField(String string) throws IOException {
        if (string == null || string.length() == 0)
        {
            return false;
        }
        return true;
    }


    // Creating a library object and initializing the arraylists
    Library library = Library.getInstance();

    // Code for new member window
    @FXML
    protected void onNewMemberSubmit() throws IOException {

        String name=nameBox.getText();
        String email=emailBox.getText();
        String ssn=SSNBox.getText();
        String address=addressBox.getText();
        String dob= String.valueOf(DoBBox.getValue());
        Date birthdate = new Date(DoBBox.getValue().toEpochDay());
        SSN num = new SSN(ssn);

        //Check if there is an empty field
        if(!checkEmptyStringField(name) || !checkEmptyStringField(address) || !checkEmptyStringField(email) ||
                !checkEmptyStringField(ssn) || !checkEmptyStringField(dob))  {

            errorMessage.setText("There is an empty field");
            return;
        }

        //check if none of the membership types have been selected
        if(!CBStudent.isSelected() && !CBProfessor.isSelected() && !CBExternal.isSelected())
        {
            errorMessage.setText("Please select the membership type.");
            return;
        }
        //check if multiple of the membership types have been selected
        if((CBStudent.isSelected() && CBProfessor.isSelected()) ||
                (CBStudent.isSelected() && CBExternal.isSelected()) ||
                (CBProfessor.isSelected() && CBExternal.isSelected()))
        {
            errorMessage.setText("Please only select one membership type.");
            return;
        }


        if(CBStudent.isSelected())
        {
            /*
            //This open the new student window
            FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("newStudent.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("New-Member");
            stage.setScene(scene);
            stage.show(); */

            int uniID = 0;
            int profID = 0;

            Events.createMembership(name, address, birthdate, email, num, uniID, profID);
            System.out.println("A new student member has been added to the system.");
            System.out.println(library.getAllMembers().get(0).getMemberID());
        }

        if(CBProfessor.isSelected())
        {
            String department = "department";
            int uniID = 0;

            Events.createMembership(name, address, birthdate, email, department, num, uniID);
            System.out.println("A new professor member has been added to the system.");
            System.out.println(library.getAllMembers().get(0).getMemberID());
        }
        if(CBExternal.isSelected())
        {
            Events.createMembership(name, address, birthdate, email, num);
            System.out.println("A new external member has been added to the system.");
            System.out.println(library.getAllMembers().get(0).getMemberID());
        }

        System.out.println(library.getAllMembers());
        //Close window.
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }

    // Code for new employee window
    @FXML
    protected void onNewEmployeeSubmit() throws IOException {
        String name=nameBox.getText();
        String email=emailBox.getText();
        String ssn=SSNBox.getText();
        String address=addressBoxField.getText();
        String dob= String.valueOf(DoBBox.getValue());
        Date birthdate = new Date(DoBBox.getValue().toEpochDay());
        SSN num = new SSN(ssn);

        //Check if there is an empty field
        if(!checkEmptyStringField(name) || !checkEmptyStringField(address) || !checkEmptyStringField(email) ||
                !checkEmptyStringField(ssn) || !checkEmptyStringField(dob))  {

            errorMessage.setText("There is an empty field");
            return;
        }

        //check if none of the membership types have been selected
        if(!RLibrarian.isSelected() && !RTechnician.isSelected())
        {
            errorMessage.setText("Please select the membership type.");
            return;
        }
        //check if multiple of the membership types have been selected
        if(( RLibrarian.isSelected() && RTechnician.isSelected() ))
        {
            errorMessage.setText("Please only select one employee type.");
            return;
        }


        if(RLibrarian.isSelected())
        {

            Events.hireLibrarian(name, address, birthdate, email, num);
            System.out.println("A new Librarian has been added to the system.");
        }

        if(RTechnician.isSelected()) {
            String department = "Books";
            Events.hireTechnician(name, address, birthdate, email, department, num);
            System.out.println("A new Technician has been added to the system.");
        }

        //Close window.
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }

    // Code for remove member window
    @FXML
    protected void onRemoveMemberSubmit() throws IOException {
        String name=nameBox.getText();
        String id=idBox.getText();
        int intID = Integer.parseInt(id);
        //Check if there is an empty field
        if(!checkEmptyStringField(name) || !checkEmptyStringField(id)) {

            errorMessage.setText("There is an empty field");
            return;
        }

        Events.removeMember(name, intID);
        System.out.println("The member " + name + " with ID: " + intID + " has been removed from the system.");
        System.out.println("Current members: " + library.getAllMembers());

        //Close window.
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onNewCollectionSubmit() throws IOException {

        String title = titleBox.getText();
        String author = authorBox.getText();
        String isbn = ISBNBox.getText();
        String genre = genreBox.getText();
        String price = priceBox.getText();
        String published = String.valueOf(DoBBox.getValue());
        Date date = new Date(DoBBox.getValue().toEpochDay());

        Integer intPrice = Integer.parseInt(price);
        Integer intISBN = Integer.parseInt(isbn);

        //Check if there is an empty field
        if(!checkEmptyStringField(title) || !checkEmptyStringField(author) || !checkEmptyStringField(genre) ||
                !checkEmptyStringField(isbn) || !checkEmptyStringField(price))  {

            errorMessage.setText("There is an empty field");
            return;
        }

        //check if none of the membership types have been selected
        if(!RBook.isSelected() && !RDVD.isSelected() && !RJournal.isSelected() && !RNewspaper.isSelected())
        {
            errorMessage.setText("Please select the membership type.");
            return;
        }
        //check if multiple of the membership types have been selected
        if( (RBook.isSelected() && RDVD.isSelected()) ||
                (RDVD.isSelected() && RJournal.isSelected()) ||
                (RJournal.isSelected() && RNewspaper.isSelected()) || (RBook.isSelected() && RNewspaper.isSelected()) || (RDVD.isSelected() && RNewspaper.isSelected()))
        {
            errorMessage.setText("Please only select one membership type.");
            return;
        }


        if(RBook.isSelected())
        {

            Events.orderBook(title, author, intPrice, genre, intISBN);
            System.out.println("A book has been added to the library");
            System.out.println(library.getAvailableItems());
        }

        if(RDVD.isSelected())
        {

            Events.orderDVD(title, intPrice, genre, intISBN);
            System.out.println("A DVD has been added to the library");
            System.out.println(library.getAvailableItems());
        }

        if(RJournal.isSelected())
        {
            Events.orderJournal(title, date, intPrice, genre, intISBN);
            System.out.println("A Journal has been added to the system.");
            System.out.println(library.getAvailableItems());
        }

        if(RNewspaper.isSelected())
        {
            Events.orderNewspaper(title, date, intPrice, genre, intISBN);
            System.out.println("A Newspaper has been added to the system.");
            System.out.println(library.getAvailableItems());
        }

        //Close window.
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();

    }


    @FXML
    protected void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

}
