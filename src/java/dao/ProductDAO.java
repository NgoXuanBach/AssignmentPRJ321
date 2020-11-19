/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Product;
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
public class ProductDAO {
    public static ArrayList<Product> getAllProduct() throws SQLException{
        ArrayList<Product> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblProduct\n" +
                        "where isDelete=0";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),rs.getString(2), rs.getDouble(3), 
                        rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            cn.close();
        }
        return list;
    }
    public static ArrayList<Product> getProductByCategory(String name) throws SQLException{
        ArrayList<Product> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblProduct\n" +
                        "where isDelete=0 and categoryName=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),rs.getString(2), rs.getDouble(3), 
                        rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            cn.close();
        }
        return list;
    }
    public static ArrayList<Product> getProductByCategoryForAd(String name) throws SQLException{
        ArrayList<Product> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblProduct\n" +
                        "where categoryName=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),rs.getString(2), rs.getDouble(3), 
                        rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            cn.close();
        }
        return list;
    }
    public static ArrayList<Product> getAllProductForAdmin() throws SQLException{
        ArrayList<Product> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblProduct\n";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),rs.getString(2), rs.getDouble(3), 
                        rs.getString(4), rs.getInt(5),rs.getString(6)));
            }
            cn.close();
        }
        return list;
    }
    public static Product getProductById(String id) throws SQLException{
        Product p = null;
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblProduct\n"
                    + "where id=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                p = new Product(rs.getString(1),rs.getString(2) , 
                        rs.getDouble(3), rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            cn.close();
        }
        return p;
    }
    public static int addProduct(Product p) throws SQLException{
        int res=0;
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="insert tblProduct\n" +
                       "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, p.getId());
            pst.setString(2, p.getName());
            pst.setDouble(3, p.getPrice());
            pst.setString(4, p.getImg());
            pst.setInt(5, p.getIsdelete());
            pst.setString(6, p.getIdcategory());
            res=pst.executeUpdate();
            cn.close();
        }
        return res;
    }
    public static int updateProduct(Product p) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="update tblProduct\n" +
                        "set name=?,price=?,img=?,categoryName=?\n" +
                        "where id=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, p.getName());
            pst.setDouble(2, p.getPrice());
            pst.setString(3, p.getImg());
            pst.setString(4, p.getIdcategory());
            pst.setString(5, p.getId());
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    public static int updateProductForDelete(String id, int a) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="update tblProduct\n" +
                        "set isDelete=?\n" +
                        "where id=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setInt(1,a);
            pst.setString(2,id);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}
