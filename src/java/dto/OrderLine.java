/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class OrderLine implements Serializable{
    private String orderlineid;
    private String productid;
    private String productname;
    private double unitprice;
    private int quantity;
    private double totalprice;

    public OrderLine() {
    }

    public OrderLine(String orderlineid, String productid, String productname, double unitprice, int quantity, double totalprice) {
        this.orderlineid = orderlineid;
        this.productid = productid;
        this.productname = productname;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getOrderlineid() {
        return orderlineid;
    }

    public void setOrderlineid(String orderlineid) {
        this.orderlineid = orderlineid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    
}
