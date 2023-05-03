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
    private Label welcomeText;

    @FXML
    protected void onNewMembershipButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newMember.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("New-Member");
        stage.setScene(scene);
        stage.show();
    }
}
