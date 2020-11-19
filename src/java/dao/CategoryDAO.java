/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
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
public class CategoryDAO {
    public static ArrayList<Category> getAllCategory() throws SQLException{
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblCategory\n";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getString(1), rs.getString(2)));
            }
            cn.close();
        }
        return list;
    }
    public static Category getCategoryByName(String name) throws SQLException{
        Category c = null;
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblCategory\n"
                    + "where Name=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                c= new Category(rs.getString(1), rs.getString(2));
            }
            cn.close();
        }
        return c;
    }
    public static int addCategory(Category c) throws SQLException{
        int res=0;
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
            String sql="insert tblCategory\n" +
                       "values(?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, c.getName());
            pst.setString(2, c.getDes());
            
            res=pst.executeUpdate();
            cn.close();
        }
        return res;
    }
}
