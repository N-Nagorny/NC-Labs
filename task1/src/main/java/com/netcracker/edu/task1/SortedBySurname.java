/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.task1;

import java.util.Comparator;

class SortedBySurname implements Comparator<Person> {
      
       public int compare(Person obj1, Person obj2) {
            
             String str1 = obj1.getSurname();
             String str2 = obj2.getSurname();
            
             return str1.compareTo(str2);
       }
}