/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Service.Discussion_service;
import Service.User_service;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.Entity.Discussion;
import pidev.Entity.User;
import pidev.Entity.admin;

/**
 *
 * @author u
 */
public class PIdev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
               Parent root = FXMLLoader.load(getClass().getResource("listuser.fxml"));

        Scene scene = new Scene(root);
        admin a1 = new admin(100,"79631106","azer","jomni",22,"55191997","mdp","azaer@aa","17","taher","ezzahra","admin","image.png");
        
        
//User u2 = new User("azer","jomni");
        //admin u = new admin(1,"09614106","azer","jomni",22,"55191997","mdp","azar@aa","17","taher","ezzahra","admin","image.png");
        //Discussion disc2 =new Discussion(1, "aaa@aaa", "cour", "bonjour", null,null, Date.valueOf(LocalDate.now()));
        //Discussion_service dis_s = new Discussion_service();
        //dis_s.ajouter(disc2);
        User_service us = new User_service();
        //us.ajouter(u3);
        //us.ajouter_admin(a1);
        //us.delete("99999999");
        //System.out.println(u3.getId());
      // List l = us.readAll();
        //System.out.println(us.readAll());
        //System.out.println(l);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
