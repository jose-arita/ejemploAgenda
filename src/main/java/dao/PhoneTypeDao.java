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
import models.PhoneType;

/**
 *
 * @author user
 */
public class PhoneTypeDao {
    
        public static boolean add(PhoneType phone){
        Connection con = null;
        PreparedStatement ps;
        String sql = "insert into tipo_telefono values( null, ? )";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, phone.getType());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("error al insertar: " + e);  
            return false;
        }       
    }
    
    public static List<PhoneType> phoneTypeList(){
        List <PhoneType> list = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from tipo_telefono";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new PhoneType (
                        rs.getInt("id"),
                        rs.getString("tipo")
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
        String sql = "delete from tipo_telefono where id=?";
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
    
    public static PhoneType getById(int id){
        PhoneType phone;
        Connection con;
        PreparedStatement ps;
        String sql= "select * from tipo_telefono where id = ?";
        ResultSet rs;
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.first();
            phone = new PhoneType(
                    rs.getInt("id"), rs.getString("nombre")
            );
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error consulta:" + e.getMessage());
            phone = null;
        }
        
        return phone;
    }
    
    public static boolean update(PhoneType phone){
        Connection con;
        PreparedStatement ps;
        String sql = "update cliente set nombre = ? where id = ?";
        int rowAffected;
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(2, phone.getId());
            ps.setString(1, phone.getType());
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
