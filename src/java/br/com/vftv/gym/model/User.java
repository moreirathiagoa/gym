/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vftv.gym.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author thiag
 */
public class User {
    
    private long id;
    private String name;
    private Date birthDate;
    private String CPF;
    private Date registrationDate;
    private Date examExperationDate;
    private Date payDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getExamExperationDate() {
        return examExperationDate;
    }

    public void setExamExperationDate(Date examExperationDate) {
        this.examExperationDate = examExperationDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public Boolean isPaymentOnDay() 
    {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime payDayExperation = this.payDay.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .plusDays(30);
                
        if(today.isAfter(payDayExperation))
            return false;
        return true;
    }
}
