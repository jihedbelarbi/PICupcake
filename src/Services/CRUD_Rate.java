/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Rate;
import Tools.cnx_Jihed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jihed
 */
public class CRUD_Rate {
    PreparedStatement pste;
    ResultSet rs;
    Connection con = cnx_Jihed.getInstance().getConnection();
    private Statement ste;
    public CRUD_Rate (){
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void insertFeedBackP(Rate r) throws SQLException { //PreparedStatement
        String requete = "insert into rate (id_patisserie,rate,nbre_rate) values (?,?,?)";
        pste = con.prepareStatement(requete);
//        pste.setInt(1,f.getClient().getId());
//        pste.setInt(2,f.getPatisserie().getID());
        pste.setInt(1,r.getPatisserie().getID());
        pste.setFloat(2,r.getRate());
        pste.setInt(3, r.getNbre_rate());
        pste.executeUpdate();
    }
}
