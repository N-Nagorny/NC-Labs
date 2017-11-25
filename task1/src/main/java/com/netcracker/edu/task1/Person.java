package com.netcracker.edu.task1;

import org.joda.time.*;

public class Person {
    
    private LocalDate dob;
    private String    surname;
    private int       id;

    /**
    * Class constructor
    * @param dob the date of birth of the person. Uses LocalDate joda-time format.
    * @param surname the surname of the person.
    * @param id the id of the person.
    */    
    public Person(LocalDate dob, String surname, int id) {
        this.dob = dob;
        this.surname = surname;
        this.id = id;
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
     * Sets the person's id.
     * @param id wanted id to set.
     */
    public void setId(int id) {
        this.id = id;
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
    public int getId() {
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
        if (id != other.id)
            return false;
        if (!(surname.equals(other.surname)))
            return false;
        return dob.equals(other.dob);
    }
}
