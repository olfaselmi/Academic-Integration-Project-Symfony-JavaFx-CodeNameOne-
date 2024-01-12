/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back.formation;

import Service.ServiceFormation;
import Entite.Formation;
import Entite.Formateur;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class AjouterFormationController implements Initializable {

    List<String> type;
    String imgG = "";
    Formation f = null;
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
    private TextField titre;
    @FXML
    private TextArea contenu;
    private ComboBox<?> formateur;
    @FXML
    private ImageView imageview;
    @FXML
    private Button imagechose;
    @FXML
    private TextField number;
    @FXML
    private ComboBox<Formateur> id_formateur;
    @FXML
    private Button btnOverview1;
    @FXML
    private Label message;
    @FXML
    private Button ajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                        setText(item.getNom()+" " +item.getPrenom());
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
        
                // controll de saisie  l formulaire lezem tkoun m3ebya 
        id_formateur.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (newValue == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        contenu.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        titre.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
        number.textProperty().addListener((ov, oldValue, newValue) -> {
            if (id_formateur.getValue() == null || contenu.getText().length() == 0 || titre.getText().length() == 0 || number.getText().length() == 0) {
                ajout.setDisable(true);
            } else {
                ajout.setDisable(false);
            }

        });
    }

    @FXML
 private void import_image(ActionEvent event) throws IOException {
        FileChooser f = new FileChooser();
       
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc = f.showOpenDialog(null);
        if (f != null) {
        String server = "ftpupload.net";
        int port = 21;
        String user = "unaux_28181550";
        String pass = "z41xcpyac60yli";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
                  String $mess =  ftpClient.getReplyString();
                     System.out.println($mess);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File firstLocalFile = new File(fc.getAbsoluteFile().toString());
   
            String firstRemoteFile ="/htdocs/"+fc.getName().toString();
            InputStream inputStream = new FileInputStream(firstLocalFile);
           
            System.out.println("Start uploading image");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
            message.setText("your image was uploaded successfully.");
            }
            else 
            { message.setText("error");}
           
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            imgG = fc.getName().toString();
            
            Path temp = Files.copy(fc.toPath(), Paths.get("C:\\Users\\anest\\Desktop\\TheLeaders\\ManUser\\src\\gui\\images\\"+imgG),StandardCopyOption.REPLACE_EXISTING); 
  
            Image i = new Image(fc.getAbsoluteFile().toURI().toString());
            imageview.setImage(i);
        }
        fc.exists();   
    }
    @FXML
    private void ajouter_formation(ActionEvent event) throws SQLException {
        ServiceFormation sf = new ServiceFormation();

        if (imgG.length() == 0) {
            sf.ajouter(new Formation(0, titre.getText(),  "",contenu.getText(), number.getText(), id_formateur.getValue().getId(), ""));
        }
        sf.ajouter(new Formation(0, titre.getText(), imgG,contenu.getText(), number.getText(), id_formateur.getValue().getId(), ""));
 
        JOptionPane.showMessageDialog(null, "Ajout effectué");
        titre.clear();
        imageview.setImage(null);
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

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCours(ActionEvent event) throws IOException {
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/back/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToClient(ActionEvent event) throws IOException {
                  Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/formation/Formation.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
