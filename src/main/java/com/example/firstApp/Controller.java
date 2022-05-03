package com.example.firstApp;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.firstApp.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginSingUpButton;

    @FXML
    private Button authSingInButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        authSingInButton.setOnAction(event ->{
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
             loginUser(loginText, loginPassword);   
            else
                System.out.println("Login and password is empty");
        });

        LoginSingUpButton.setOnAction(event -> {
            openNewScene("singUp.fxml");

        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
       ResultSet result =  dbHandler.getUser(user);

       int counter = 0;

           try {
               while(result.next())
                   counter++;
           } catch (SQLException e) {
               e.printStackTrace();
           }

       if(counter >= 1) {
           System.out.println("Success");
           openNewScene("app.fxml");
       }
        else{
           Shake userLoginAnim = new Shake(loginField);
           Shake userPassAnim = new Shake(passwordField);
           userLoginAnim.playAnim();
           userPassAnim.playAnim();
       }
    }
    public void openNewScene(String window){
        LoginSingUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
//                e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}