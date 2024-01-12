/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back.cours;

import Entite.Cours;
import Entite.Enseignant;
import Entite.Formateur;
import Entite.Formation;
import Service.ServiceCours;
import Service.SessionFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class DetailsController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnUser;
    @FXML
    private Button btnFormation;
    @FXML
    private Button btncours;
    @FXML
    private Button btnOverview1;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Label nombre;
    @FXML
    private Label name;
    @FXML
    private Label places;
    @FXML
    private Label places1;
    @FXML
    private Text contenu;
    @FXML
    private Label date_debut;
    @FXML
    private Label date_fin;
    String nom_form;
    private int id_formation = 0;
    SessionFormation SF = SessionFormation.getInstance();
    @FXML
    private Label nom_enseignant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_formation = SF.getId_formation();
        nom_form = null;
        try {
            displayAll();

            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayAll() throws SQLException {

        ServiceCours sf = new ServiceCours();

        Cours C = sf.details(id_formation);
        Enseignant En = sf.detailsEnseignant(C.getIdEnseignant());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = dateFormat.format(C.getDate_debut());
        String strDate2 = dateFormat.format(C.getDate_fin());
        date_debut.setText(strDate1);
        date_fin.setText(strDate2);
        name.setText(C.getTitre());
        contenu.setText(C.getContenu());
        places.setText(C.getPlacedisponible());
        nom_form = En.getNom() + " " + En.getPrenom();
        nom_enseignant.setText(nom_form);

    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }

    @FXML
    private void goToFormation(ActionEvent event) throws IOException {
             SF.cleanUserSession();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCours(ActionEvent event) throws IOException {
     SF.cleanUserSession();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToClient(ActionEvent event) throws IOException {
             SF.cleanUserSession();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

}
