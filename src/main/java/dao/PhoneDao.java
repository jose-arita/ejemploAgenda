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
import models.Phone;

/**
 *
 * @author user
 */
public class PhoneDao {
    
        public static boolean add(Phone phone){
        Connection con = null;
        PreparedStatement ps;
        String sql = "insert into telefono values( null, ?, ?, ? )";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, phone.getNumber());
            ps.setInt(2, phone.getCostumerId());
            ps.setInt(3, phone.getTypeId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("error al insertar: " + e);  
            return false;
        }       
    }
    
    public static List<Phone> getAll(){
        List <Phone> list = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select c.id, c.nombre, tt.id, tt.tipo, t.id, t.numero "
                + "from cliente c, telefono t, tipo_telefono tt "
                + "where t.contacto_id = c.id "
                + "and t.tipo_telefono_id = tt.id";
        
        try {
            con = ConeccionDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(
                        rs.getInt("t.id"),
                        rs.getString("t.numero"),
                        rs.getInt("c.id"),
                        rs.getString("c.nombre"),
                        rs.getInt("tt.id"),
                        rs.getString("tt.tipo")
                        
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
    
    
}
