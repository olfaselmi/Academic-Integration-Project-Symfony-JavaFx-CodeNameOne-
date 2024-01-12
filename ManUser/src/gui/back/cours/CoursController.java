/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back.cours;

import Entite.Cours;
import Service.ServiceCours;
import Service.ServiceFormation;
import Service.SessionFormation;
import gui.back.formation.FormationController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author emna
 */
public class CoursController implements Initializable {

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
    private TableView<Cours> view;
    @FXML
    private TableColumn<?, ?> col_formateur;
    @FXML
    private TableColumn<?, ?> col_places;
    @FXML
    private TableColumn<?, ?> col_contenu;
    @FXML
    private Button ajouter;
    @FXML
    private TextField rechercher;
    @FXML
    private Label nombre;
    @FXML
    private RadioButton tri1;
    @FXML
    private ToggleGroup tri;
    @FXML
    private RadioButton tri2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            displayAll();
            addButtonToTable();
            rechercher();
        } catch (SQLException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addButtonToTable() throws SQLException {
        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>> cellFactory;
        cellFactory = new Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>>() {
            @Override
            public TableCell<Cours, Void> call(final TableColumn<Cours, Void> param) {
                final TableCell<Cours, Void> cell = new TableCell<Cours, Void>() {

                    private final Button update = new Button();
                    private final Button delete = new Button("");
                    private final Button details = new Button("");
                    Label lb = new Label("  ");
                    Label lb2 = new Label("  ");
                    private final HBox pane = new HBox(details, lb2, update, lb, delete);

                    {
                        Image btn_details = new Image(getClass().getResourceAsStream("../images/details.png"));
                        Image btn_update = new Image(getClass().getResourceAsStream("../images/update.png"));
                        Image btn_delete = new Image(getClass().getResourceAsStream("../images/delete.png"));
                        update.setGraphic(new ImageView(btn_update));
                        delete.setGraphic(new ImageView(btn_delete));
                        details.setGraphic(new ImageView(btn_details));
                        update.setMaxSize(10, 10);
                        delete.setMaxSize(10, 10);
                        details.setMaxSize(10, 10);
                        final Tooltip tooltip = new Tooltip();
                        tooltip.setText("supprimer ");
                        delete.setTooltip(tooltip);
                        final Tooltip tooltip2 = new Tooltip();
                        tooltip2.setText("voir details ");
                        details.setTooltip(tooltip2);
                        final Tooltip tooltip3 = new Tooltip();
                        tooltip3.setText("modifier ");
                        update.setTooltip(tooltip3);
                        details.setOnAction((ActionEvent event) -> {
                            Parent page2;
                            try {
                                Cours cours = getTableView().getItems().get(getIndex());
                                SessionFormation.getInstace(cours.getId());

                                page2 = FXMLLoader.load(getClass().getResource("Details.fxml"));
                                Scene scene2 = new Scene(page2);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(scene2);
                                window.show();

                            } catch (IOException ex) {
                                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        update.setOnAction((ActionEvent event) -> {
                            Parent page2;
                            try {
                                Cours cours = getTableView().getItems().get(getIndex());
                                SessionFormation.getInstace(cours.getId());

                                page2 = FXMLLoader.load(getClass().getResource("UpdateCours.fxml"));
                                Scene scene2 = new Scene(page2);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(scene2);
                                window.show();

                            } catch (IOException ex) {
                                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        delete.setOnAction((ActionEvent event) -> {

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("suppression");
                            alert.setHeaderText("Voulez-vous vraiment supprimer ce cours ?");
                            Optional<ButtonType> option = alert.showAndWait();

                            if (option.get() == ButtonType.OK) {

                                ServiceCours sf = new ServiceCours();
                                Cours cours = getTableView().getItems().get(getIndex());

                                try {
                                    sf.delete(cours.getId());
                                    displayAll();
                                } catch (SQLException ex) {
                                    Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);

                        setGraphic(empty ? null : pane);
                    }
                };
                return cell;
            }
        };

        actionCol.setCellFactory(cellFactory);

        view.getColumns().add(actionCol);
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
    private void goToClient(ActionEvent event) throws IOException {
            Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/front/cours/Cours.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AjouterCours.fxml")));
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void rechercher() throws SQLException {
        ServiceCours sf = new ServiceCours();
        ArrayList listcs = (ArrayList) sf.DisplayAll();
        ObservableList OCours = FXCollections.observableArrayList(listcs);
        FilteredList<Cours> filteredData = new FilteredList<>(OCours, p -> true);
        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getTitre()).toLowerCase().contains(lowerCaseFilter) || String.valueOf(myObject.getPlacedisponible()).toLowerCase().contains(lowerCaseFilter) || String.valueOf(myObject.getContenu()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<Cours> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(view.comparatorProperty());
        view.setItems(sortedData);
    }

    public void displayAll() throws SQLException {

        ServiceCours sf = new ServiceCours();
        List lists = sf.DisplayAll();
        int number = sf.count();
        ObservableList listFormations = FXCollections.observableArrayList(lists);

        view.setItems(listFormations);

        nombre.setText(Integer.toString(number));
        col_formateur.setCellValueFactory(new PropertyValueFactory<>("titre"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        col_places.setCellValueFactory(new PropertyValueFactory<>("placedisponible"));

    }

    @FXML
    public void tri_Nombre_places() throws SQLException {

        ServiceCours sf = new ServiceCours();
        List listcs = sf.triParNombre();

        ObservableList listFormations = FXCollections.observableArrayList(listcs);

        view.setItems(listFormations);

        col_formateur.setCellValueFactory(new PropertyValueFactory<>("titre"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        col_places.setCellValueFactory(new PropertyValueFactory<>("placedisponible"));
    }

    @FXML
    public void tri_Titre() throws SQLException {

        ServiceCours sf = new ServiceCours();
        List listcs = sf.triParTitre();

        ObservableList listFormations = FXCollections.observableArrayList(listcs);

        view.setItems(listFormations);

        col_formateur.setCellValueFactory(new PropertyValueFactory<>("titre"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        col_places.setCellValueFactory(new PropertyValueFactory<>("placedisponible"));
    }

}
