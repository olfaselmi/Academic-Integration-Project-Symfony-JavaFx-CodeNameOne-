/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back.cours;

import Entite.Cours;
import Entite.Enseignant;
import Entite.Formation;

import Service.ServiceCours;
import Service.ServiceFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class AjouterCoursController implements Initializable {
    Cours f = null;
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
    private TextField titre;
    @FXML
    private TextArea contenu;
    @FXML
    private TextField number;
    @FXML
    private ComboBox<Enseignant> id_enseignant;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private Button ajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Callback<ListView<Enseignant>, ListCell<Enseignant>> cellFactory = new Callback<ListView<Enseignant>, ListCell<Enseignant>>() {

            @Override
            public ListCell<Enseignant> call(ListView<Enseignant> l) {
                return new ListCell<Enseignant>() {

                    @Override
                    protected void updateItem(Enseignant item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                        setText(item.getNom()+" " +item.getPrenom());
                        }
                    }
                };
            }
        };

        id_enseignant.setButtonCell(cellFactory.call(null));
        id_enseignant.setCellFactory(cellFactory);
        //remplissage du combobox
        ServiceCours us = new ServiceCours();
        List<Enseignant> arr = new ArrayList<>();
        try {
            arr = us.findEnseignants();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Enseignant u : arr) {
            String nom = u.getNom();
            String prenom = u.getPrenom();
    

            id_enseignant.getItems().add(u);
        }
              date_debut.setValue(LocalDate.now());
        date_debut.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });
                  date_fin.setValue(date_debut.getValue());
        date_fin.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
               

                setDisable(empty || date.compareTo(date_debut.getValue()) < 0);
            }
        });
        
             // controll de saisie  l formulaire lezem tkoun m3ebya 
        id_enseignant.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (newValue == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        contenu.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_enseignant.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        titre.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_enseignant.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        number.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_enseignant.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
    }    
   @FXML
    private void ajouter_cours(ActionEvent event) throws SQLException {
        ServiceCours sf = new ServiceCours();
            LocalDate date_D = date_debut.getValue();
            LocalDateTime date_De = date_D.atTime(11, 10);
            java.sql.Date date_Debut = java.sql.Date.valueOf(date_De.toLocalDate());
            LocalDate date_f = date_fin.getValue();
            LocalDateTime date_fe = date_f.atTime(11, 10);
            java.sql.Date date_fin = java.sql.Date.valueOf(date_fe.toLocalDate());
        sf.ajouter(new Cours(0, titre.getText(),contenu.getText(),date_Debut ,date_fin, number.getText(), id_enseignant.getValue().getId(), ""));
 
        JOptionPane.showMessageDialog(null, "Ajout effectué");
        titre.clear();
   
        contenu.setText(null);

    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }

    @FXML
    private void goToFormation(ActionEvent event) throws IOException {
                Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCours(ActionEvent event) throws IOException {
                Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToClient(ActionEvent event) {
    }

    
}
