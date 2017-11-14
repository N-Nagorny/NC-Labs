/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.task1;

import org.joda.time.*;

/**
 *
 * @author PC-Administrator
 */
public class Person {
    
    private LocalDate dob;
    private String    surname;
    private int       id;
    
    public Person(LocalDate dob, String surname, int id) {
        this.dob = dob;
        this.surname = surname;
        this.id = id;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public int getId() {
        return id;
    }
    
    public int getAge() {
        DateTime dtob = dob.toDateTimeAtStartOfDay();
        return Years.yearsBetween(dtob, new DateTime()).getYears();
    }
}
