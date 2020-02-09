/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.model;

import java.util.Date;

/**
 *
 * @author thiag
 */
public class AccessControl {
    
    private Date entrace;
    private Date exit;
    User user;

    public Date getEntrace() {
        return entrace;
    }

    public void setEntrace(Date entrace) {
        this.entrace = entrace;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    Boolean isWorkingOut() {
        if(this.exit == null)
            return true;
        return false;
        
    }    
    
}
