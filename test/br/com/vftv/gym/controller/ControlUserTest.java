/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.controller;

import br.com.vftv.gym.dao.UserDAO;
import br.com.vftv.gym.model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.stubbing.Answer;

/**
 *
 * @author felli
 */
public class ControlUserTest {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private User user;
    private List<User> listAllsUser = new ArrayList<>();
    private UserDAO dao = Mockito.mock(UserDAO.class);
    private UserControl userControl;
    
    public ControlUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        listAllsUser.add(user);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void getAllsUserTest(){
        //cenario
        this.userControl = new UserControl(this.dao);
        when(this.dao.getUserList()).thenReturn(listAllsUser);
        //action
        
        List<User> list = this.userControl.getAllsUser();
        
        //validation
        assertFalse(list.isEmpty());
        
    }
}
