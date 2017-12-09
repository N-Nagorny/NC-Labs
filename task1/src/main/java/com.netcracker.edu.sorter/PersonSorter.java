package com.netcracker.edu.sorter;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;

import java.util.Comparator;

public interface PersonSorter {
    public PersonStorage sort(PersonStorage personStorage, Comparator<Person> comparator);
}
