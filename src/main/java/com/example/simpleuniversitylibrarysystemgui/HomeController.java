package com.example.simpleuniversitylibrarysystemgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class HomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onNewMembershipButtonClick() {
        welcomeText.setText("This is very stupid!!!!");
    }
}
