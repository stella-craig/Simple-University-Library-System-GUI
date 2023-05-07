package com.example.simpleuniversitylibrarysystemgui;
import javafx.scene.control.*;
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



    //The following code is for the newMember.fxml window
    @FXML    TextField nameBox;
    @FXML    TextField emailBox;
    @FXML    TextField SSNBox;
    @FXML    TextArea addressBox;
    @FXML    DatePicker DoBBox;
    @FXML    Button newMemberCancel;
    @FXML    Button newMemberSubmit;
    @FXML    Label newMemberErrorMessage;
    @FXML    CheckBox CBStudent;
    @FXML    CheckBox CBProfessor;
    @FXML    CheckBox CBExternal;
    @FXML    TextField NSStuID;
    @FXML    TextField NSProfID;
    @FXML    Button NSSubmit;
    @FXML    Button NSCancel;

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
    Library mainStreet = new Library("Main Street Public Library", "123 main street");


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

            newMemberErrorMessage.setText("There is an empty field");
            return;
        }

        //check if none of the membership types have been selected
        if(!CBStudent.isSelected() && !CBProfessor.isSelected() && !CBExternal.isSelected())
        {
            newMemberErrorMessage.setText("Please select the membership type.");
            return;
        }
        //check if multiple of the membership types have been selected
        if((CBStudent.isSelected() && CBProfessor.isSelected()) ||
                (CBStudent.isSelected() && CBExternal.isSelected()) ||
                (CBProfessor.isSelected() && CBExternal.isSelected()))
        {
            newMemberErrorMessage.setText("Please only select one membership type.");
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

            libFunctions.Events.createMembership(name, address, birthdate, email, num, uniID, profID);
            System.out.println("A new student member has been added to the system.");
        }

        if(CBProfessor.isSelected())
        {
            String department = "department";
            int uniID = 0;
            libFunctions.Events.createMembership(name, address, birthdate, email, department, num, uniID);
            System.out.println("A new professor member has been added to the system.");
        }
        if(CBExternal.isSelected())
        {
            libFunctions.Events.createMembership(name, address, birthdate, email, num);
            System.out.println("A new external member has been added to the system.");
        }

        //Close window.
        Stage stage = (Stage) newMemberSubmit.getScene().getWindow();
        stage.close();
    }
    @FXML
    protected void onNewMemberCancel() {
        Stage stage = (Stage) newMemberCancel.getScene().getWindow();
        stage.close();
    }

}
