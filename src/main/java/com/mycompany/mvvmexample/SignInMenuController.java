/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvvmexample;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Person;

/**
 *
 * @author juilliardwu
 */
public class SignInMenuController {
    @FXML
    private Button SignIn;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private void SignInButton() throws IOException{
        CollectionReference userTable = App.fstore.collection("SignIn Reference");
        ApiFuture<QuerySnapshot> checkUser = userTable.whereEqualTo("UserName", username.getText()).get();
        ApiFuture<QuerySnapshot> checkPassword = userTable.whereEqualTo("Password", password.getText()).get();
        try {
            if(!checkUser.get().getDocuments().isEmpty() || !checkPassword.get().getDocuments().isEmpty()){
                switchAcessFBView();
            }
                } catch (InterruptedException ex) {
            Logger.getLogger(SignInMenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SignInMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void switchSignUpMenu() throws IOException {
        App.setRoot("SignUpMenu.fxml");
    }
    @FXML
    private void switchAcessFBView() throws IOException {
        App.setRoot("AccessFBView.fxml");
    }
    
}
