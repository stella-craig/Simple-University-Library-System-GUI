package com.example.simpleuniversitylibrarysystemgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    protected void onNewMembershipButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newMember.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New-Member");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onNewCollectionButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New-Collection");
        stage.setScene(scene);
        stage.show();
    }
}
