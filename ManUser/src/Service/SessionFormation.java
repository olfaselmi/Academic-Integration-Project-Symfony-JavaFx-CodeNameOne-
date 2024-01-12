/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author emna
 */
public class SessionFormation {


    private static SessionFormation instance;
    private int id_formation;
    
    
    public SessionFormation(int id) {
        this.id_formation = id;
    }
    public static SessionFormation getInstance() {
        return instance;
        
    }
    public static void setInstance(SessionFormation instance) {
        SessionFormation.instance = instance; 
    }
     public static SessionFormation getInstace(int id) {
        if(instance == null) {
         instance = new SessionFormation(id);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "FormationSession{" + "id_formation=" + id_formation + '}';
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }
      public void cleanUserSession() {
       
        id_formation = 0;
      instance = null;

    } 
    
}
