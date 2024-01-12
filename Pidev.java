/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Service.demandeService;
import Service.offreService;
import entite.demande;
import entite.offre;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class Pidev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //test demande
        Scene scene = new Scene(root);
        //demande d=new demande("2021-03-05", "2021-03-09",23,0,0);
        //demandeService ds=new demandeService();
        //ds.ajouterDemande(d);
        //ds.modifierDemande(d, 2);
        /*List<demande> list=ds.readAll();
        System.out.println(list.get(0).toString());
        ds.supprimerDemande(2);*/
        
        offre o=new offre(234,false,1,3);
        offreService os=new offreService();
        //os.modifierOffre(o, 1);
        //List<offre> list=os.readAll();
        //System.out.println(list.get(0).toString());
        stage.setScene(scene);
        os.supprimerOffre(1);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
