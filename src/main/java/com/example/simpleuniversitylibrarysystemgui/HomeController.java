package com.example.simpleuniversitylibrarysystemgui;
import javafx.scene.control.TextField;
import libFunctions.*;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Label;

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
    @FXML
    TextField nameBox;
    @FXML
    protected void onNewMemberSubmit() {
        String s=nameBox.getText();
        System.out.println(s);
        Platform.exit();
    }

}
