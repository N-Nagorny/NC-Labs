package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;

import java.util.Comparator;

public class BubbleSort implements PersonSorter {
    @Override
    public PersonStorage sort(PersonStorage ps, Comparator<Person> comparator) {
        Person[] arr = ps.getArr();
        int tail = ps.getTail();
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
        return new PersonStorage(arr, tail);
    }
}
