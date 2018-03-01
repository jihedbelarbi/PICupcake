/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Patisserie;
import Entities.Rate;
import Tools.DataSource;
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
    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public CRUD_Rate() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertRateP(Rate r) throws SQLException { //PreparedStatement
        String requete = "insert into rate (nbre_rate,rate,id_patisserie) values (?,?,?)";
        pste = con.prepareStatement(requete);
        pste.setInt(1, r.getNbre_rate());
        pste.setDouble(2, r.getRate());
        pste.setInt(3, r.getId_patisserie());
        pste.executeUpdate();
    }

    public void updateRateP(Rate r) throws SQLException {
        String requete = "UPDATE rate SET `rate`.`rate`=?,`rate`.`nbre_rate`=?  WHERE `rate`.`id_patisserie`=? ";
        pste = con.prepareStatement(requete);
        pste.setDouble(1, r.getRate());
        pste.setInt(2, r.getNbre_rate());
        pste.setInt(3, 1);
        pste.executeUpdate();
    }

    public Rate findById(int i) throws SQLException {
        Rate r = null;
        String requete = "select * from rate where id_patisserie=?";
        try {
            PreparedStatement pste = con.prepareStatement(requete);
            pste.setInt(1, i);
            rs = pste.executeQuery();
            while (rs.next()) {
                r = new Rate(rs.getInt("id_rate"), rs.getFloat("rate"), rs.getInt("nbre_rate"));
                return r;
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
        }
        return r;
    }
}
