package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.AbstractRep;
import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;
import com.netcracker.edu.task1.Repository;

import java.util.Comparator;

public class BubbleSort<T> implements Sorter<T> {
    @Override
    public void sort(Object[] arr, Comparator<T> comparator) {
        Object temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (comparator.compare((T) arr[j - 1], (T) arr[j]) > 0) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}