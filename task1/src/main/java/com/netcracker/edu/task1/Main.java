package com.netcracker.edu.task1;

import org.joda.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate dob = new LocalDate(1996, 8, 3);
        Person nagorny = new Person(dob, "Nagorny");
        System.out.println(nagorny.getAge());
        Person goryainov = new Person(dob, "Goryainov");
        Person goryainov2 = new Person(dob.plusYears(9), "Norkin");
        Person goryainov3 = new Person(dob.plusYears(6), "Moryakov");
        Person goryainov4 = new Person(dob.plusYears(8), "Khorkin");
        System.out.println(goryainov.getId());
        PersonStorage ps = new PersonStorage(1);
        ps.addPerson(nagorny);
        System.out.println(ps.getTail());
        ps.addPerson(goryainov);
        ps.addPerson(goryainov2);
        ps.addPerson(goryainov3);
        ps.addPerson(goryainov4);
        System.out.println(ps.getTail());
        ps.sortBySurname();
        //ps.deletePerson(goryainov3.getId());
        ps.print();

        ps.searchByAge(12).print();
        System.out.println("\n");
        ps.searchByAge(21).print();
    }
    
}
