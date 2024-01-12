/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import utile.DataBase;
import entity.Ecole;
import entity.modules;
import service.EcoleService;
import service.ModulesService;

/**
 *
 * @author Yasmine Boulares
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
     //   Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
      //  Scene scene = new Scene(root);
        
       // stage.setScene(scene);
        //stage.show();
        Ecole e1= new Ecole("ab","ennasr","enn","tunis");
        EcoleService es= new EcoleService();
        es.ajouterEcolePst(e1);
        
        modules ml = new modules();
        ModulesService mss = new ModulesService();
        mss.ajouterModulesPst(ml);
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
        
        
    }
    
}
