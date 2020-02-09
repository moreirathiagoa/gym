/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private User user;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws ParseException {
        
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void releaseUserPaymentOnDay() throws ParseException
    {
        //cenario
        user.setPayDay(Calendar.getInstance().getTime());
        
        //action
        Boolean result = user.isPaymentOnDay();
        
        //validation
        assertTrue(result);
    }
    
    
    
    @Test
    public void releaseUserNotPaymentOnDay() throws ParseException
    {
        //cenario
        user.setPayDay(sdf.parse("07/01/2020"));
        
        //action
        Boolean result = user.isPaymentOnDay();
        
        //validation
        assertFalse(result);
    }
    

    
   //Created Method isOlderThanEightenn
    
    @Test
    public void isOlderThanEightenn() throws ParseException
    {
        //cenario
        User user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        user.setPayDay(Calendar.getInstance().getTime());
        
        //action
        Boolean result = user.isPaymentOnDay();
        
        //validation
        assertTrue(result);
    }
    
    
    @Test
    public void isOlderThannotEightenn() throws ParseException
    {
        //cenario
        User user = new User();
        user.setName("Fulano da Silva");
        user.setBirthDate(sdf.parse("20/12/1985"));
        user.setCPF("11843771766");
        user.setRegistrationDate(sdf.parse("20/12/2000"));
        user.setExamExperationDate(sdf.parse("20/12/2020"));
        user.setPayDay(sdf.parse("07/01/2020"));
        //action
        Boolean result = user.isPaymentOnDay();
        //validation
        assertFalse(result);
    }
    
    
}
