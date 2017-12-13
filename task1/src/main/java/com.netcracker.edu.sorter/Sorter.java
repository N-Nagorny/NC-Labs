package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;

import java.util.Comparator;
import java.util.SortedMap;

public interface Sorter<T> {
    void sort(Object[] arr, Comparator<T> comparator);
}
