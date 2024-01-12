/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front;

import Service.ServiceUser;
//import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class ForgotController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private Button btn;
    @FXML
    private ImageView back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   /* @FXML
    private void forgotpass(ActionEvent event) throws SQLException, MessagingException, UnsupportedEncodingException {
    String mai = mail.getText();
    ServiceUser user = new ServiceUser();
    String a=user.forgotpasss(mai);
    Email email = new Email("montassar43@gmail.com","montassar007");
        email.setFrom("montassar43@gmail.com", "Solidarity With Refugees");
        email.setSubject("Get your password");
        email.setContent("<h1> Your Password is</h1>"+a, "text/html");
        email.addRecipient(mai);
        email.send();
    }*/

    @FXML
    private void back(MouseEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        mail.getScene().setRoot(root);
        InscriptionController rc=fxml.getController();
    }
    
}
