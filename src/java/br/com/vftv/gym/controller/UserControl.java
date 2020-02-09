/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.controller;

import br.com.vftv.gym.dao.UserDAO;
import br.com.vftv.gym.model.User;
import java.util.List;

/**
 *
 * @author felli
 */
public class UserControl {
    
    private UserDAO userDAO;

    public UserControl() {
        this.userDAO = new UserDAO();
    }

    //Construct to user by test
    public UserControl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    public List<User> getAllsUser(){
        return this.userDAO.getUserList();
    }
    
    
}
