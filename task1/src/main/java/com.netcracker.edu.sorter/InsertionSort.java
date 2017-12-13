package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;

import java.util.Comparator;

public class InsertionSort<T> implements Sorter<T> {

    @Override
    public void sort(Object[] arr, Comparator<T> comparator) {
        Object temp;
        int j;
        for(int i = 0; i < arr.length - 1; i++){
            if (comparator.compare((T)arr[i], (T)arr[i + 1]) > 0) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && comparator.compare((T)temp, (T)arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }
}
