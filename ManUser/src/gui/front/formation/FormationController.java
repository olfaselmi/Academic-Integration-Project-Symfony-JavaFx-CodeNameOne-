/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front.formation;

import Entite.Formation;
import Service.ServiceFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class FormationController implements Initializable {

    @FXML
    private Label nbnotif;
    @FXML
    private Button profile;
    @FXML
    private ImageView btnprofile;
    @FXML
    private Label text;
    @FXML
    private Button profile1;
    @FXML
    private Button profile11;
    @FXML
    private ImageView btnprofile11;
    @FXML
    private VBox liste_formation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            DisplayOne();
        } catch (SQLException ex) {
            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisplayOne() throws SQLException, IOException {
        ServiceFormation ServF = new ServiceFormation();
        ArrayList<Formation> TabT = ServF.DisplayAll();

        for (Formation f : TabT) {
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FormationOne.fxml"));
            Parent n = (Parent) loader.load();
            gui.front.formation.FormationOneController form = loader.getController();
            form.InitFormation(f);
            liste_formation.getChildren().add(n);
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

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void GoToCours(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void GoToAdmin(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
