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
public class Task1 {
    public static void main(String[] args) {
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person person = new Person(dob, "Nagorny", 1);
        System.out.print(person.getAge());
    }
    
}
