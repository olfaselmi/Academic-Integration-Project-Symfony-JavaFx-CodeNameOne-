/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front.cours;

import Entite.Cours;
import Entite.Formation;
import Service.ServiceCours;
import Service.ServiceFormation;
import gui.front.formation.FormationController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class CoursController implements Initializable {

    @FXML
    private Label nbnotif;
    @FXML
    private Button profile;
    @FXML
    private ImageView btnprofile;
    @FXML
    private Button profile1;
    @FXML
    private Button profile11;
    @FXML
    private ImageView btnprofile11;
    @FXML
    private Label text;
    @FXML
    private VBox liste_cours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
           DisplayOne();
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

    public void DisplayOne() throws SQLException, IOException {
        ServiceCours ServC = new ServiceCours();
        ArrayList<Cours> TabT = ServC.DisplayAll();

        for (Cours c : TabT) {
       
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CoursOne.fxml"));
            Parent n = (Parent) loader.load();
            gui.front.cours.CoursOneController form = loader.getController();
            form.InitCours(c);
            liste_cours.getChildren().add(n);
        }
    }
    @FXML
    private void account(ActionEvent event) {
    }
    @FXML
    private void GoToFormation(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void GoToCours(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void GoToAdmin(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }
    
}
