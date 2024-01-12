/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u
 */
public class DataBase {
    
    
    private String url= "jdbc:mysql://localhost:3306/pidev";
    private String login="root";
    private String pwd="";

    private Connection cnx;

    private static DataBase instance;

    private DataBase() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DataBase getInstance(){
        if(instance==null)
            instance=new DataBase();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
