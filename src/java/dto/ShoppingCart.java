/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ShoppingCart implements Serializable{
    private Product pd;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(Product pd, int quantity) {
        this.pd = pd;
        this.quantity = quantity;
    }

    public Product getPd() {
        return pd;
    }

    public void setPd(Product pd) {
        this.pd = pd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public static int isExist(String id, ArrayList<ShoppingCart> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getPd().getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
