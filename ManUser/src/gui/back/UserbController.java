/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back;

import Entite.Respecole;
import Entite.User;
import Service.ServiceUser;
import Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class UserbController implements Initializable {
    private Connection con;
    private Statement ste;
    
    
    
    
    
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
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Button ajouterre;
    @FXML
    private Button btnUser;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TableView<User> Userview;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;
    @FXML
    private TableColumn<?, ?> col_count;
    @FXML
    private TableColumn<?, ?> col_mail;
    @FXML
    private TableColumn<?, ?> col_tel;
    @FXML
    private TableColumn<?, ?> col_us;
    @FXML
    private TableColumn<?, ?> col_role;
    @FXML
    private TableColumn<?, ?> col_date;
    ObservableList<User> oblist = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();
    @FXML
    private TableView<User> RespEview;
    @FXML
    private TableColumn<?, ?> col_nomre;
    @FXML
    private TableColumn<?, ?> col_prenomre;
    @FXML
    private TableColumn<?, ?> col_countre;
    @FXML
    private TableColumn<?, ?> col_mailre;
    @FXML
    private TableColumn<?, ?> col_telre;
    @FXML
    private TableColumn<?, ?> col_usre;
    @FXML
    private TableColumn<?, ?> col_rolere;
    @FXML
    private TableColumn<?, ?> col_datere;
    
    ObservableList<User> oblistre = FXCollections.observableArrayList();
    
    @FXML
    private TableView<User> RespCview;
    @FXML
    private TableColumn<?, ?> col_nomrc;
    @FXML
    private TableColumn<?, ?> col_prenomrc;
    @FXML
    private TableColumn<?, ?> col_countrc;
    @FXML
    private TableColumn<?, ?> col_mailrc;
    @FXML
    private TableColumn<?, ?> col_telrc;
    @FXML
    private TableColumn<?, ?> col_usrc;
    @FXML
    private TableColumn<?, ?> col_rolerc;
    @FXML
    private TableColumn<?, ?> col_daterc;
    
    ObservableList<User> oblistrc = FXCollections.observableArrayList();
   // ServiceUser user = new ServiceUser();
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private Button btnser;

    /**
     * Initializes the controller class.
     */
    
    public UserbController() {
        con = DataBase.getInstance().getConnection();
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();
        initTableRE();
        initTableRC();
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }
    private void initTable() {
        
        try {
            oblist= (ObservableList<User>) user.readAll() ;
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_count.setCellValueFactory(new PropertyValueFactory<>("country"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_us.setCellValueFactory(new PropertyValueFactory<>("username"));
            col_role.setCellValueFactory(new PropertyValueFactory<>("roles"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("dateins"));
            Userview.setItems(oblist);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    private void initTableRE() {
        
        try {
            oblistre= (ObservableList<User>) user.readAllre();
            col_nomre.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenomre.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_countre.setCellValueFactory(new PropertyValueFactory<>("country"));
            col_mailre.setCellValueFactory(new PropertyValueFactory<>("mail"));
            col_telre.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_usre.setCellValueFactory(new PropertyValueFactory<>("username"));
            col_rolere.setCellValueFactory(new PropertyValueFactory<>("roles"));
            col_datere.setCellValueFactory(new PropertyValueFactory<>("dateins"));
            RespEview.setItems(oblistre);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
    private void initTableRC() {
        
        try {
            oblistrc= (ObservableList<User>) user.readAllrc();
            col_nomrc.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenomrc.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_countrc.setCellValueFactory(new PropertyValueFactory<>("country"));
            col_mailrc.setCellValueFactory(new PropertyValueFactory<>("mail"));
            col_telrc.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_usrc.setCellValueFactory(new PropertyValueFactory<>("username"));
            col_rolerc.setCellValueFactory(new PropertyValueFactory<>("roles"));
            col_daterc.setCellValueFactory(new PropertyValueFactory<>("dateins"));
            RespCview.setItems(oblistrc);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

    @FXML
    private void ajouterre(ActionEvent event) throws SQLException {
        
        System.out.println("zzz"); 
        User re=RespEview.getSelectionModel().getSelectedItem();
        ste = con.createStatement();
        /*System.out.println(rc.getIdu());*/
        if (!re.equals(null)) 
        {System.out.println(re);
        
        String requeteInsert = "INSERT INTO `pidevv`.`respecole` (`id`, `idUser`, `idEcole`) VALUES (NULL,'"+re.getIdu()+"',2);";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"Responsable ajouté avec succées");
        }
        
    }
    @FXML
    private void delete(ActionEvent event) throws SQLException {
    User c=Userview.getSelectionModel().getSelectedItem();
        if (!c.equals(null)) 
        user.delete(c.getUsername());
        initTable();
        initTableRE();
        initTableRC();
    }

    @FXML
    private void rechercher(ActionEvent event) {
        
        LocalDate date11=date1.getValue();
        LocalDate date22=date2.getValue();
        String chainedate1="";
        String chainedate2="";
        if(date11 != null)
        {
            chainedate1=date11.toString();
        }
         if(date22 != null)
        {
            chainedate2=date22.toString();
        }
       
        try {
            oblist= (ObservableList<User>) user.rechercheentredate(chainedate1, chainedate2) ;
        
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_count.setCellValueFactory(new PropertyValueFactory<>("country"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_us.setCellValueFactory(new PropertyValueFactory<>("username"));
            col_role.setCellValueFactory(new PropertyValueFactory<>("roles"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("dateins"));
            Userview.getItems().clear();
            Userview.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
