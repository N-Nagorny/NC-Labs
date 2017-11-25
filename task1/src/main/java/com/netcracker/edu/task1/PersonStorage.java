package com.netcracker.edu.task1;

import java.util.Arrays;
import java.util.Comparator;

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
        int tmp = -1;
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
    
    public int getTail() {
        return tail;
    }
    
    public Person getPerson(int id) {
        int tmp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == id) {
                tmp = id;
            }
        }
        return arr[id];
    }
    
    private void sort(Comparator<Person> comparator) {
        Person temp;
        for (int i = 0; i < tail; i++) {
        for (int j = 1; j < (tail - i); j++) {
            if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
        }
    }
    
    public void sortByAge() {
        sort(new SortedByAge() {
            
            @Override
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
        });
    }
    
    public void sortById() {
        sort(new SortedById() {
            
            @Override
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
        });
    }
    
    public void sortBySurname() {
        sort(new SortedBySurname() {

            @Override
            public int compare(Person obj1, Person obj2) {
            
            String str1 = obj1.getSurname();
            String str2 = obj2.getSurname();
            
            return str1.compareTo(str2);
            }
        });
    }
    
    public void print() {
        for (Person i : arr) {
            System.out.println("ID: " + i.getId() + "; Surname: " + i.getSurname() +
                    "; Age: " + i.getAge());
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        
        PersonStorage other = (PersonStorage) obj;
        if (tail != other.tail)
            return false;
        return Arrays.equals(arr, other.arr);
    }
}
