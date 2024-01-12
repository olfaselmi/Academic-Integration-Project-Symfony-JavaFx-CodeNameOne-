/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front.cours;

import Entite.Cours;
import Entite.Enseignant;
import Entite.Formateur;
import Entite.Formation;
import Service.ServiceCours;
import Service.ServiceFormation;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class CoursOneController implements Initializable {

    @FXML
    private Label Titre;
    @FXML
    private Label Nombre;
    @FXML
    private Text contenu;
    @FXML
    private ImageView image;
    @FXML
    private Label enseignant;
    @FXML
    private Label date_debut;
    @FXML
    private Label date_fin;
    public ServiceCours servC = new ServiceCours();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void InitCours(Cours c) throws SQLException {

        Cours cours = servC.details(c.getId());
        Enseignant En = servC.detailsEnseignant(c.getIdEnseignant());

        Titre.setText("" + cours.getTitre());
        Nombre.setText("" + cours.getPlacedisponible());
        contenu.setText("" + cours.getContenu());
        enseignant.setText(En.getPrenom() + " " + En.getNom());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = dateFormat.format(c.getDate_debut());
        String strDate2 = dateFormat.format(c.getDate_fin());
        date_debut.setText(strDate1);
        date_fin.setText(strDate2);
    }
}
