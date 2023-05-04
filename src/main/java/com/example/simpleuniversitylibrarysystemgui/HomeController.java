package com.example.simpleuniversitylibrarysystemgui;
import javafx.scene.control.*;
import libFunctions.*;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.*;

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


    @FXML
    protected void onNewMemberSubmit() {

        String name=nameBox.getText();
        String email=emailBox.getText();
        String ssn=SSNBox.getText();
        String address=addressBox.getText();
        String dob= String.valueOf(DoBBox.getValue());

        //Check if name is empty
        if (name == null || name.length() == 0)
        {
            //System.out.println("Error: Empty name.");
            newMemberErrorMessage.setText("Error: Empty name.");
            return;
        }
        //check if email is empty
        if (email == null || email.length() == 0)
        {
            //System.out.println("Error: Empty email.");
            newMemberErrorMessage.setText("Error: Empty email.");
            return;
        }
        //check if ssn is empty
        if (ssn == null || ssn.length() == 0)
        {
            //System.out.println("Error: Empty SSN.");
            newMemberErrorMessage.setText("Error: Empty SSN.");
            return;
        }
        //check if address is empty
        if (address == null || address.length() == 0)
        {
            //System.out.println("Error: Empty Address.");
            newMemberErrorMessage.setText("Error: Empty Address.");
            return;
        }
        //check if dob is empty
        if (dob == null || dob.length() == 0)
        {
            //System.out.println("Error: Empty DoB.");
            newMemberErrorMessage.setText("Error: Empty DoB.");
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
