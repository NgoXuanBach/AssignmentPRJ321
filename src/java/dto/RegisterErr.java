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
public class RegisterErr implements Serializable{
    private String usernameErr;
    private String passwordErr;
    private String confirmErr;
    private String fullnameErr;
    private String duplicateUsername;

    public RegisterErr() {
    }

    public RegisterErr(String usernameErr, String passwordErr, String confirmErr, String fullnameErr, String duplicateUsername) {
        this.usernameErr = usernameErr;
        this.passwordErr = passwordErr;
        this.confirmErr = confirmErr;
        this.fullnameErr = fullnameErr;
        this.duplicateUsername = duplicateUsername;
    }

    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmErr() {
        return confirmErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    public String getFullnameErr() {
        return fullnameErr;
    }

    public void setFullnameErr(String fullnameErr) {
        this.fullnameErr = fullnameErr;
    }

    public String getDuplicateUsername() {
        return duplicateUsername;
    }

    public void setDuplicateUsername(String duplicateUsername) {
        this.duplicateUsername = duplicateUsername;
    }
    
    
}
