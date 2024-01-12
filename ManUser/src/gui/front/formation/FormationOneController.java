/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front.formation;

import Entite.Formation;
import Entite.Formateur;
import Service.ServiceFormation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.F;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class FormationOneController implements Initializable {

    @FXML
    private ImageView image;
    private Label matricule;
    public ServiceFormation servF = new ServiceFormation();
    @FXML
    private Label Titre;
    @FXML
    private Label Nombre;
    @FXML
    private Label Formateur;
    @FXML
    private Text contenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void InitFormation(Formation f) throws SQLException {

        Formation forma = servF.details(f.getId());
        Formateur Fo = servF.detailsFormateur(f.getIdFormateur());

        Titre.setText("" + forma.getTitre());
        Nombre.setText("" + forma.getPlacedisponible());
        contenu.setText("" + forma.getContenu());
        image.setImage(new Image("/gui/images/"+f.getImage()));
        Formateur.setText(Fo.getPrenom() + " " + Fo.getNom());

    }

}
