package com.netcracker.edu.task1.test;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;
import org.joda.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonStorageTest {
    @org.junit.jupiter.api.Test
    void getTail() {
        PersonStorage ps = new PersonStorage();
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person goryainov = new Person(dob, "Goryainov");
        Person goryainov2 = new Person(dob.plusYears(9), "Norkin");
        Person goryainov3 = new Person(dob.plusYears(6), "Moryakov");
        Person goryainov4 = new Person(dob.plusYears(8), "Khorkin");
        ps.addPerson(goryainov);
        ps.addPerson(goryainov2);
        ps.addPerson(goryainov3);
        ps.addPerson(goryainov4);

        assertEquals(4, ps.getTail());
    }

}