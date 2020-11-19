/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderLine;
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
public class OrderLineDAO {
    public static int createOrderLine(OrderLine ol) throws SQLException{
        Connection cn = MyConnection.makeConnection();
        int a = 0;
        if(cn!=null){
            String sql="insert tblOrderLine\n" +
                        "values(?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ol.getOrderlineid());
            pst.setString(2, ol.getProductid());
            pst.setString(3, ol.getProductname());
            pst.setDouble(4, ol.getUnitprice());
            pst.setInt(5, ol.getQuantity());
            pst.setDouble(6, ol.getTotalprice());
            a=pst.executeUpdate();
            cn.close();
        }
        return a;
    }
    public static ArrayList<OrderLine> getOrderLineById(String id) throws SQLException{
        ArrayList<OrderLine> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblOrderLine\n" +
                        "where OrderID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new OrderLine(rs.getString(1), rs.getString(2), 
                        rs.getString(3),rs.getDouble(4), rs.getInt(5),rs.getDouble(6)));
            }
            cn.close();
        }
        return list;
    }
}
