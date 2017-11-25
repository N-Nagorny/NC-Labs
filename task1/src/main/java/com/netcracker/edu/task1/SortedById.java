/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.task1;

import java.util.Comparator;

class SortedById implements Comparator<Person> {
      
       public int compare(Person obj1, Person obj2) {
            
             int id1 = obj1.getId();
             int id2 = obj2.getId();

             if(id1 > id2) {
                    return 1;
             }
             else if(id1 < id2) {
                    return -1;
             }
             else {
                    return 0;
             }
       }
}
