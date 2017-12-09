package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;

import java.util.Comparator;

public class InsertionSort implements PersonSorter {

    @Override
    public PersonStorage sort(PersonStorage ps, Comparator<Person> comparator) {
        Person temp;
        int j;
        int tail = ps.getTail();
        Person[] arr = ps.getArr();
        for(int i = 0; i < tail - 1; i++){
            if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && comparator.compare(temp, arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        return new PersonStorage(arr, tail);
    }
}
