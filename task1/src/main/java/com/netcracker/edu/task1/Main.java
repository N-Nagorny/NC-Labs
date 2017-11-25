package com.netcracker.edu.task1;

import org.joda.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person nagorny = new Person(dob, "Nagorny", 1);
        System.out.println(nagorny.getAge());
        Person goryainov = new Person(dob, "Goryainov", 2);
        System.out.println(goryainov.getId());
        PersonStorage ps = new PersonStorage(1);
        ps.addPerson(nagorny);
        System.out.println(ps.getTail());
        ps.addPerson(goryainov);
        System.out.println(ps.getTail());
        ps.sortBySurname();
        ps.print();
    }
    
}
