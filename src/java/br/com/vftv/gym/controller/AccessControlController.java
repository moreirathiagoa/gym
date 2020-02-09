/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.controller;

import br.com.vftv.gym.dao.AccessControlDAO;
import br.com.vftv.gym.model.AccessControl;
import br.com.vftv.gym.model.User;

/**
 *
 * @author thiag
 */
public class AccessControlController {
    
    private AccessControlDAO dao;
    
    public AccessControlController() {
    }
    
    public AccessControlController(AccessControlDAO dao) {
        this.dao = dao;
    }
    
    public Boolean isWorkingOut(User user)
    {
        AccessControl accessControl = dao.getLastAcces(user);
        if (accessControl.getExit()==null)
            return true;
        return false;
    }
    
    public void registerEntrace(User user) throws Exception
    {
        if(user.isPaymentOnDay())
        {
            dao.registerEntrace(user);
        }
        else
            throw new Exception("User is not available to workout");
    }
}
