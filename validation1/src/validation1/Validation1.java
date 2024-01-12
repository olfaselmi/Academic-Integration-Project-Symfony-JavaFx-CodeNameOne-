/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation1;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.service_cour;
import utils.DataBase;
import utils.cour;
 

/**
 *
 * @author emna ketata
 */
public class Validation1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
       // Scene scene = new Scene(root);
        
        /*SimpleDateFormat sp=new SimpleDateFormat ("yyyy-MM-dd");
        java.util.Date d3=sp.parse("2020-08-12");
          java.util.Date d4=sp.parse("2020-08-12");
       */
        
                         cour c1 = new cour("math","12-12-20","10-10-10",1,1,1);
                         
                         service_cour sc1 = new service_cour();
                         sc1.ajouter(c1);

        //stage.setScene(scene);
        //stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
