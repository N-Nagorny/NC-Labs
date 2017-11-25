/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.task1;

import java.util.Comparator;

class SortedByAge implements Comparator<Person> {
      
       public int compare(Person obj1, Person obj2) {
            
             int age1 = obj1.getAge();
             int age2 = obj2.getAge();

             if(age1 > age2) {
                    return 1;
             }
             else if(age1 < age2) {
                    return -1;
             }
             else {
                    return 0;
             }
       }
}
