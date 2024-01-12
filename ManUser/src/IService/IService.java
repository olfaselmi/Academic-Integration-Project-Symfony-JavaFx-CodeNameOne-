/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;
import Entite.User;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Asus X550V
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    void ajouter_respec(T t) throws SQLException;
    boolean delete(String nom) throws SQLException;
    boolean update(T t,String id) throws SQLException;
    boolean modify(T t,String id) throws SQLException;
    ObservableList<User> readAll() throws SQLException;
    List<T> rechercheavance(String n) throws SQLException;
    List<T> tri() throws SQLException;
    ObservableList<T> rechercheentredate(String d1 , String d2) throws SQLException;
    int moyenne() throws SQLException;
    int auth(String mail,String pwd) throws SQLException;
    int preauth(String mail,String pwd) throws SQLException;
    String forgotpasss(String mail) throws SQLException;
    String getUser(String mail) throws SQLException;
    User SerachUser(String username) throws SQLException;
}
