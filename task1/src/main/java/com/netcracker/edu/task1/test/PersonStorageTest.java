package com.netcracker.edu.task1.test;

import com.netcracker.edu.task1.Person;
import com.netcracker.edu.task1.PersonStorage;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonStorageTest {
    @Test
    void getPersonById() {
        PersonStorage ps = new PersonStorage();
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person goryainov = new Person(dob, "Goryainov");
        UUID gor = goryainov.getId();
        ps.addItem(goryainov);
        assertEquals(goryainov, ps.getPersonById(gor));
    }

    @Test
    void searchBySurnameAndAge() {
        PersonStorage ps = new PersonStorage();
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person goryainov = new Person(dob, "Goryainov");
        Person goryainov2 = new Person(dob.plusYears(3), "Morkin");
        Person goryainov3 = new Person(dob.plusYears(6), "Noryakov");
        Person goryainov4 = new Person(dob.plusYears(8), "Porkin");
        ps.addItem(goryainov);
        ps.addItem(goryainov2);
        ps.addItem(goryainov3);
        ps.addItem(goryainov4);
        ps.sortByAge();
        PersonStorage ps1 = ps;
        ps1.sortBySurname();
        assertEquals(ps1, ps);

    }

    @Test
    void getTail() {
        PersonStorage ps = new PersonStorage();
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person goryainov = new Person(dob, "Goryainov");
        Person goryainov2 = new Person(dob.plusYears(9), "Norkin");
        Person goryainov3 = new Person(dob.plusYears(6), "Moryakov");
        Person goryainov4 = new Person(dob.plusYears(8), "Khorkin");
        ps.addItem(goryainov);
        ps.addItem(goryainov2);
        ps.addItem(goryainov3);
        ps.addItem(goryainov4);

        assertEquals(4, ps.getTail());
    }

}