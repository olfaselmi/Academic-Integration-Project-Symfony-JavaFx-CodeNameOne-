/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back;

import Entite.Categorie;
import Entite.News;
import Entite.User;
import Service.ServiceCategorie;
import Service.ServiceNews;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */

public class NewsController implements Initializable {

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
    private TableView<News> Newview;
    @FXML
    private TableColumn<?, ?> cl_tit;
    @FXML
    private TableColumn<?, ?> cl_desc;
    @FXML
    private TableColumn<?, ?> cl_date;
    @FXML
    private TableColumn<?, ?> cl_cat;
    ServiceNews news = new ServiceNews();
    ServiceCategorie cat = new ServiceCategorie();
    ObservableList<News> oblist = FXCollections.observableArrayList();
    @FXML
    private Button btncat;
    @FXML
    private TextField titre;
    @FXML
    private TextField desc;
    @FXML
    private Button addbtn;
    @FXML
    private ComboBox<Categorie> nomcat;
    @FXML
    private Button delbtn;
    @FXML
    private TextField descup;
    @FXML
    private TextField titup;
    @FXML
    private ComboBox<Categorie> nomcat1;
    @FXML
    private PieChart chart;

    /**
     * Initializes the controller class.
     */
    
    public void rafraichir()
    {
          ResultSet stat=null;
          
        try {
            stat=news.satistique();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        chart.getData().clear();
        
        try {
            while(stat.next())
            {
                
                
                chart.getData().add(new PieChart.Data(stat.getString(1),stat.getDouble(2)));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
     }
        
   
            
        
        
        
        
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();
        combo();
        combo1();
        this.rafraichir();
 
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }
    public void combo()
    {
        try {
            ObservableList<Categorie> list=cat.affichecat();
            nomcat.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void combo1()
    {
        try {
            ObservableList<Categorie> list=cat.affichecat();
            nomcat1.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initTable() {
        
        try {
            oblist= (ObservableList<News>) news.readAll() ;
            cl_tit.setCellValueFactory(new PropertyValueFactory<>("titre"));
            cl_desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
            cl_date.setCellValueFactory(new PropertyValueFactory<>("datepub"));
            cl_cat.setCellValueFactory(new PropertyValueFactory<>("nomcat"));
            Newview.setItems(oblist);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

    @FXML
    private void categ(ActionEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("Cat.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
        
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
            
        try {
            News u = new News(titre.getText(),desc.getText(),nomcat.getValue().getNomcat());
            news.ajouter(u);
            initTable();
            clearAll();
            this.rafraichir();
        } catch (SQLException ex) {
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
    News c=Newview.getSelectionModel().getSelectedItem();
        if (!c.equals(null)) 
        news.delete(c.getTitre());
        initTable();
        this.rafraichir();
    }
    private void clear(ActionEvent event) {
        clearAll();
    }
    private void clearAll(){
    
        titre.setText("");
        desc.setText("");
        nomcat.setValue(null);
        titup.setText("");
        descup.setText("");
        nomcat1.setValue(null);
    }

    @FXML
    private void update(ActionEvent event) {
    
        try {
            News c=Newview.getSelectionModel().getSelectedItem();
            news.update(c.getTitre(), titup.getText(), descup.getText(), nomcat1.getValue().getNomcat());
            initTable();
        clearAll();
        this.rafraichir();
                     } catch (SQLException ex) {
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
}
