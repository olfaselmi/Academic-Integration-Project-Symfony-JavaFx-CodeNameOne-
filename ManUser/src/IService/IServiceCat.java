/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;
import Entite.Categorie;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
/**
 *
 * @author Asus X550V
 */
public interface IServiceCat<T> {
    
    void ajouter(T t) throws SQLException;
    boolean delete(String nom) throws SQLException;
    boolean update(String nom1,String nom2) throws SQLException;
    List<Categorie> readAll() throws SQLException;
    ObservableList<Categorie> affichecat() throws SQLException;
    
}
