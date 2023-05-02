/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvvmexample;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author juilliardwu
 */
public class SignUpMenuController {
    @FXML
    private Button SignUp;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    @FXML
    private void switchSignInMenu() throws IOException {
        App.setRoot("SignInMenu.fxml");
    }
    @FXML
    private void SignUpButtonHendler(){
        addData();
    }
    public void addData() {

        DocumentReference docRef = App.fstore.collection("SignIn Reference").document(UUID.randomUUID().toString());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("UserName", username.getText());
        data.put("Password", password.getText());
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
    }
}
