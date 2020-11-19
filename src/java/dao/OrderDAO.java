/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.MyConnection;

/**
 *
 * @author DELL
 */
public class OrderDAO {
    public static int createOrder(Order o) throws SQLException{
        Connection cn = MyConnection.makeConnection();
        int a = 0;
        if(cn!=null){
            String sql="insert tblOrder\n" +
                        "values(?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, o.getOrderid());
            pst.setString(2, o.getDate());
            pst.setDouble(3, o.getTotal());
            pst.setString(4, o.getUsername());
            a=pst.executeUpdate();
            cn.close();
        }
        return a;
    }
    public static Order getOrderById(String id) throws SQLException{
        Order o = null;
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblOrder\n" +
                        "where OrderID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                o = new Order(rs.getString(1), rs.getString(2), 
                        rs.getDouble(3), rs.getString(4));
            }
            cn.close();
        }
        return o;
    }
    public static ArrayList<Order> getOrderByUs(String u) throws SQLException{
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblOrder\n" +
                        "where username=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getString(1), rs.getString(2), 
                        rs.getDouble(3), rs.getString(4)));
            }
            cn.close();
        }
        return list;
    }
    public static ArrayList<Order> getAllOrder() throws SQLException{
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblOrder\n";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getString(1), rs.getString(2), 
                        rs.getDouble(3), rs.getString(4)));
            }
            cn.close();
        }
        return list;
    }
}
