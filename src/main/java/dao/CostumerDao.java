/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connetion.ConeccionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Costumer;

/**
 *
 * @author user
 */
public class CostumerDao {
    
    public static boolean add(Costumer costumer){
        Connection con = null;
        PreparedStatement ps;
        String sql = "insert into cliente values( null, ? )";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, costumer.getName());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("error al insertar: " + e);  
            return false;
        }       
    }
    
    public static List<Costumer> costumerList(){
        List <Costumer> list = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from cliente";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Costumer (
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error al insertar: " + e);  
            list.clear();
        }
        
        return list;
    }
    
    public static boolean remove(int id){
        Connection con;
        PreparedStatement ps;
        String sql = "delete from cliente where id=?";
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("error al insertar: " + e);
            return false;
        }  
    }
    
    public static Costumer getById(int id){
        Costumer cos;
        Connection con;
        PreparedStatement ps;
        String sql= "select * from cliente where id = ?";
        ResultSet rs;
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.first();
            cos = new Costumer(
                    rs.getInt("id"), rs.getString("nombre")
            );
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error consulta:" + e.getMessage());
            cos = null;
        }
        
        return cos;
    }
    
    public static boolean update(Costumer costumer){
        Connection con;
        PreparedStatement ps;
        String sql = "update cliente set nombre = ? where id = ?";
        int rowAffected;
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(2, costumer.getId());
            ps.setString(1, costumer.getName());
            rowAffected = ps.executeUpdate();
            ps.close();
            con.close();
            return rowAffected==1;
        } catch (SQLException e) {
            System.out.println("error consulta:" + e.getMessage());
            return false;
        }
    }
}
