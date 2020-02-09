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
import java.util.Objects;

/**
 *
 * @author felli
 */
public class User {

    private long id;
    private String name;
    private Date birthDate;
    private String CPF;
    private Date registrationDate;
    private Date examExperationDate;
    private Date payDay;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.birthDate);
        hash = 29 * hash + Objects.hashCode(this.CPF);
        hash = 29 * hash + Objects.hashCode(this.registrationDate);
        hash = 29 * hash + Objects.hashCode(this.examExperationDate);
        hash = 29 * hash + Objects.hashCode(this.payDay);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.CPF, other.CPF)) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        if (!Objects.equals(this.examExperationDate, other.examExperationDate)) {
            return false;
        }
        if (!Objects.equals(this.payDay, other.payDay)) {
            return false;
        }
        return true;
    }

    public Boolean isPaymentOnDay() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime payDayExperation = this.payDay.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .plusDays(30);

        if (today.isAfter(payDayExperation)) {
            return false;
        }
        return true;
    }

    public Boolean isOlderThanEighteen() throws ParseException {
        LocalDateTime hojemenosdezoito = Calendar.getInstance().getTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .plusYears(-18);

        LocalDateTime nascimento = this.birthDate
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        
        if (hojemenosdezoito.isAfter(nascimento)) {
            System.out.println("Maior");
            return true;
            
        }else{
            System.out.println("Menor");
            return false;
           
        }
    }
}
