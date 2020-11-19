/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author DELL
 */
public class AddProductErr {
    private String iderr;
    private String nameerr;
    private String priceerr;
    private String imgerr;

    public AddProductErr() {
    }

    public AddProductErr(String iderr, String nameerr, String priceerr, String imgerr) {
        this.iderr = iderr;
        this.nameerr = nameerr;
        this.priceerr = priceerr;
        this.imgerr = imgerr;
    }

    public String getIderr() {
        return iderr;
    }

    public void setIderr(String iderr) {
        this.iderr = iderr;
    }

    public String getNameerr() {
        return nameerr;
    }

    public void setNameerr(String nameerr) {
        this.nameerr = nameerr;
    }

    public String getPriceerr() {
        return priceerr;
    }

    public void setPriceerr(String priceerr) {
        this.priceerr = priceerr;
    }

    public String getImgerr() {
        return imgerr;
    }

    public void setImgerr(String imgerr) {
        this.imgerr = imgerr;
    }
    
}
