/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back.formation;

import Entite.Formateur;
import Entite.Formation;

import Service.ServiceFormation;
import Service.SessionFormation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class UpdateFormationController implements Initializable {

    List<String> type;
    String imgG = "";
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
    private ImageView imageview;
    @FXML
    private TextField titre;
    @FXML
    private TextField contenu;
    @FXML
    private TextField number;
    @FXML
    private ComboBox<Formateur> id_formateur;
    @FXML
    private Button imagechose;
    @FXML
    private Label nom;
    private int id_formation = 0;
    SessionFormation SF = SessionFormation.getInstance();
    @FXML
    private Label formateur;
    @FXML
    private Button btnOverview1;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_formation = SF.getId_formation();
        Callback<ListView<Formateur>, ListCell<Formateur>> cellFactory = new Callback<ListView<Formateur>, ListCell<Formateur>>() {

            @Override
            public ListCell<Formateur> call(ListView<Formateur> l) {
                return new ListCell<Formateur>() {

                    @Override
                    protected void updateItem(Formateur item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.getNom() + " " + item.getPrenom());
                        }
                    }
                };
            }
        };

        id_formateur.setButtonCell(cellFactory.call(null));
        id_formateur.setCellFactory(cellFactory);
        //remplissage du combobox
        ServiceFormation us = new ServiceFormation();
        List<Formateur> arr = new ArrayList<>();
        try {
            arr = us.findFormateurs();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFormationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Formateur u : arr) {
            String nom = u.getNom();
            String prenom = u.getPrenom();

            id_formateur.getItems().add(u);
        }
        type = new ArrayList<>();
        type.add("*.jpg");
        type.add("*.png");
        try {
            displayAll();

        } catch (SQLException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                // controll de saisie  l formulaire lezem tkoun m3ebya 
        id_formateur.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (newValue == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                update.setDisable(true);
            } else {
                update.setDisable(false);
            }

        });
        contenu.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                update.setDisable(true);
            } else {
                update.setDisable(false);
            }

        });
        titre.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                update.setDisable(true);
            } else {
                update.setDisable(false);
            }

        });
        number.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                update.setDisable(true);
            } else {
                update.setDisable(false);
            }

        });
    }

    public void displayAll() throws SQLException {

        ServiceFormation sf = new ServiceFormation();

        Formation F = sf.details(id_formation);
        Formateur Fo = sf.detailsFormateur(F.getIdFormateur());
        nom.setText(F.getTitre());
        titre.setText(F.getTitre());
        contenu.setText(F.getContenu());
        number.setText(F.getPlacedisponible());
        imageview.setImage(new Image("/gui/images/"+F.getImage()));
        formateur.setText(Fo.getPrenom() + " " + Fo.getNom());

    }

    @FXML
 private void import_image(ActionEvent event) throws IOException {
        FileChooser f = new FileChooser();
       
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc = f.showOpenDialog(null);
        if (f != null) {
     
   
            imgG = fc.getName().toString();
             Path temp = Files.copy(fc.toPath(), Paths.get("C:\\Users\\anest\\Desktop\\TheLeaders\\ManUser\\src\\gui\\images\\"+imgG),StandardCopyOption.REPLACE_EXISTING); 
  
            Image i = new Image(fc.getAbsoluteFile().toURI().toString());
            imageview.setImage(i);
        }
        fc.exists();

    }

    @FXML
    private void modifier_formation(ActionEvent event) throws SQLException {
        ServiceFormation sf = new ServiceFormation();
        Formation F = sf.details(id_formation);
        String img = "";
        int id_format;
        if (imgG.length() == 0) {
            img = F.getImage();
        } else {
            img = imgG;
        }

        if (id_formateur.getSelectionModel().isEmpty()) {
            id_format = F.getIdFormateur();
        } else {
            id_format = id_formateur.getValue().getId();
        }

        sf.modifier(new Formation(id_formation, titre.getText(), img, contenu.getText(), number.getText(), id_format, ""));

        JOptionPane.showMessageDialog(null, "modification effectué");

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

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCours(ActionEvent event) throws IOException {
          SF.cleanUserSession();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToClient(ActionEvent event) throws IOException {
         SF.cleanUserSession();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

}
