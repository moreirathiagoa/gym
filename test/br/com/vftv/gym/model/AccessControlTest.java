/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiag
 */
public class AccessControlTest {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public AccessControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isWorkingOutConfirm() throws ParseException
    {
        //cenario
        User user;
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        user.setPayDay(Calendar.getInstance().getTime());
        
        AccessControl accessControl = new AccessControl();
        accessControl.setEntrace(Calendar.getInstance().getTime());
        accessControl.setUser(user);
                
        //action
        Boolean result = accessControl.isWorkingOut();
        
        //validation
        assertTrue(result);
    }
    
    @Test
    public void isNotWorkingOutConfirm() throws ParseException
    {
        //cenario
        User user;
        user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        user.setPayDay(Calendar.getInstance().getTime());
        
        AccessControl accessControl = new AccessControl();
        
        LocalDateTime dateEntrace = Calendar.getInstance().getTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .plusHours(-1);
        
        accessControl.setEntrace(Date.from(dateEntrace.atZone( ZoneId.systemDefault()).toInstant()));
        accessControl.setExit(Calendar.getInstance().getTime());
        accessControl.setUser(user);
                
        //action
        Boolean result = accessControl.isWorkingOut();
        
        //validation
        assertFalse(result);
    }
}
