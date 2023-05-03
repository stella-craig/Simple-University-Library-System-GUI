package com.example.simpleuniversitylibrarysystemgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("This is very stupid!!!!");
    }

    @FXML
    protected void onNewMembershipButtonClick() {
        welcomeText.setText("This is very stupid!!!!");
    }

}