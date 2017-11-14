/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.task1;

/**
 *
 * @author PC-Administrator
 */
public class PersonStorage {
    
    private Person[] arr;
    private int tail = 0;
    
    public PersonStorage(int arrSize) {
        arr = new Person[arrSize];
    }
            
    public void addPerson(Person person) {
        if (arr[arr.length - 1] != null)  {
            Person[] newArr = new Person[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[tail++] = person;
    }
    
    public void deletePerson(int id) {
        long tmp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == id) {
                tmp = id;
            }
        }
        
        if (id != tmp) {
            Person[] newArr = new Person[arr.length - 2];
            System.arraycopy(arr, 0, newArr, 0, id);
            System.arraycopy(arr, id + 2, newArr, id + 1, arr.length);
            arr = newArr;
        }
    }
    
}
