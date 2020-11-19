/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
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
public class AccountDAO {
    public static Account getAccount(String u, String p) throws SQLException{
        Account a=null;
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblAccount\n" +
                        "where username=? and password=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u);
            pst.setString(2, p);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4),rs.getInt(5));
            }
            cn.close();
        }
        return a;
    }
    public static ArrayList<Account> getAllAccount(int a) throws SQLException{
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="select *\n" +
                        "from tblAccount\n"
                    + "where isAdmin=?";
                        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, a);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4),rs.getInt(5)));
            }
            cn.close();
        }
        return list;
    }
    public static int createAccount(Account a) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="insert tblAccount\n" +
                       "values(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getFullname());
            pst.setInt(4, a.getIsAdmin());
            pst.setInt(5, a.getIsdelete());
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
    public static Account getAccountByUn(String u) throws SQLException{
        Account a=null;
        Connection cn=MyConnection.makeConnection();
        if(cn!=null){
           String sql="select *\n" +
                        "from tblAccount\n" +
                        "where username=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4), rs.getInt(5));
            }
            cn.close();
        }
        return a; 
        
    }
    public static int updateAccountForDelete(String username, int a) throws SQLException{
        Connection cn=MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="update tblAccount\n" +
                        "set isDelete=?\n" +
                        "where username=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setInt(1,a);
            pst.setString(2,username);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}
