package com.netcracker.edu.task1;

import org.joda.time.*;
import java.util.UUID;

public class Person {
    
    private LocalDate dob;
    private String    surname;
    private UUID      id;

    /**
    * Class constructor
    * @param dob the date of birth of the person. Uses LocalDate joda-time format.
    * @param surname the surname of the person.
     */
    public Person(LocalDate dob, String surname) {
        this.dob = dob;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }
    
    /**
    * Sets the person's date of birth.
    * @param dob wanted date of birth to set.
    */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    
    /**
     * Sets the person's surname.
     * @param surname wanted surname to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    /**
     * Gets the person's date of birth.
     * @return the person's date of birth.
     */
    public LocalDate getDob() {
        return dob;
    }
    
    /**
     * Gets the person's surname.
     * @return the person's surname.
     */
    public String getSurname() {
        return surname;
    }
    
    /** Gets the person's id.
     * @return the person's id. 
     */
    public UUID getId() {
        return id;
    }

    public int getAge() {
        DateTime dtob = dob.toDateTimeAtStartOfDay();
        return Years.yearsBetween(dtob, new DateTime()).getYears();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        
        Person other = (Person) obj;
        if (!(id.equals(other.id)))
            return false;
        if (!(surname.equals(other.surname)))
            return false;
        return dob.equals(other.dob);
    }
}
