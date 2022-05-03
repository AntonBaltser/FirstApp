package com.example.firstApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button singUpBtn;

    @FXML
    private CheckBox singUpCheckBoxFemale;

    @FXML
    private CheckBox singUpCheckBoxMale;

    @FXML
    private TextField singUpCountry;

    @FXML
    private TextField singUpLastname;

    @FXML
    private TextField singUpName;

    @FXML
    void initialize() {
        singUpBtn.setOnAction( event -> {
            singUpNewUser();
    });
    }
    private void singUpNewUser() {

            DatabaseHandler dbHandler = new DatabaseHandler();

            String firstName = singUpName.getText();
            String lastName = singUpLastname.getText();
            String userName = loginField.getText();
            String password = passwordField.getText();
            String country = singUpCountry.getText();
            String gender = "";
            if(singUpCheckBoxMale.isSelected())
                gender = "Мужской";
            else
                gender = "Женский";

            User user = new User(firstName, lastName, userName, password, country, gender);


            dbHandler.singUpUser(user);


  }
}
