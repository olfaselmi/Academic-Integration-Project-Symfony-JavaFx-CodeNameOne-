/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.service_cour;
import utils.cour;

/**
 *
 * @author emna ketata
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label_ajouter;
    
    @FXML
    private Button button_ajouter ;
    
    @FXML
    private TextField contenuE ;
    
    @FXML
    private TextField dateDE ;
    
    @FXML
    private TextField dateFE ;
    
    @FXML
    private TextField placeDispoE ;
    
    @FXML
    private TextField idEnseigE ;
    
    @FXML
    private TextField emploiE ;

    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
    @FXML
    private void ajoutecour(ActionEvent event) {
        String contenu = contenuE.getText();
        String dateD = dateDE.getText();
        String dateF = dateFE.getText();
        String placeDispo = placeDispoE.getText();
        String idEnseig = idEnseigE.getText();
        String emploi = emploiE.getText();
        //int age=Integer.parseInt(agee);
        
        service_cour sc3 = new service_cour();
        //String crypted = Servicebcrypt.hashpw(pwd, staticvar.SALT);
        cour c3 =new  cour( contenu,dateD , dateF , placeDispo, idEnseig , emploi  );
        cour.ajouter(c3);
        
        /*FXMLLoader loader = new FXMLLoader
        (getClass()
        .getResource("login.fxml"));
        try {
        Parent root = loader.load();
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }*/
    }
   
    }
    

      
    

