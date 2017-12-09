/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.comparator;

import com.netcracker.edu.task1.Person;

import java.util.Comparator;
import java.util.UUID;

public class SortedById implements Comparator<Person> {
      
       public int compare(Person obj1, Person obj2) {
            
             String id1 = obj1.getId().toString();
             String id2 = obj2.getId().toString();

             return id1.compareTo(id2);
       }
}
