/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.controller;

import br.com.vftv.gym.dao.AccessControlDAO;
import br.com.vftv.gym.model.AccessControl;
import br.com.vftv.gym.model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;

/**
 *
 * @author thiag
 */
public class AccessControlControllerTest {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private AccessControlDAO dao;
    private User user;
    
    public AccessControlControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = Mockito.mock(AccessControlDAO.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isWorkingOut method, of class AccessControlController.
     */
    @Test
    public void isUserWorkingOutTest() throws ParseException {
        //cenario
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        
        AccessControl accessControl = new AccessControl();
        accessControl.setEntrace(Calendar.getInstance().getTime());
        accessControl.setUser(user);
        
        Mockito.when(dao.getLastAcces(user)).thenReturn(accessControl);
        AccessControlController accesControlController = new AccessControlController(dao);
        
        //action
        Boolean result = accesControlController.isWorkingOut(user);
        
        //validation
        assertTrue(result);
    }
    
    @Test
    public void isUserNotWorkingOutTest() throws ParseException {
        //cenario
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        
        AccessControl accessControl = new AccessControl();
        LocalDateTime dateEntrace = Calendar.getInstance().getTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .plusHours(-1);
        accessControl.setEntrace(Date.from(dateEntrace.atZone( ZoneId.systemDefault()).toInstant()));
        accessControl.setExit(Calendar.getInstance().getTime());
        accessControl.setUser(user);
        
        Mockito.when(dao.getLastAcces(user)).thenReturn(accessControl);
        AccessControlController accesControlController = new AccessControlController(dao);
        
        //action
        Boolean result = accesControlController.isWorkingOut(user);
        
        //validation
        assertFalse(result);
    }
    
    @Test 
    public void entraceGranted() throws ParseException, Exception
    {
        //cenario
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        user.setPayDay(Calendar.getInstance().getTime());
        
        //action
        AccessControlController accesControlController = new AccessControlController(dao);
        accesControlController.registerEntrace(user);
    }
    
    
    @Test
    public void entraceNotGranted() throws ParseException
    {
        //cenario
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        //user.setPayDay(Calendar.getInstance().getTime());
        user.setPayDay(sdf.parse("01/01/2020"));
        
        //Mockito.when(dao.registerEntrace(user)).thenReturn(null);
        AccessControlController accesControlController = new AccessControlController(dao);
        
        try {
            accesControlController.registerEntrace(user);
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("User is not available to workout"));
        }
    }
}
