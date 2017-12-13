package com.netcracker.edu.task1;

import java.util.*;

import com.netcracker.edu.comparator.SortedByAge;
import com.netcracker.edu.comparator.SortedById;
import com.netcracker.edu.comparator.SortedBySurname;
import com.netcracker.edu.config.Configurator;
import com.netcracker.edu.searcher.person.SearchByAge;
import com.netcracker.edu.searcher.person.SearchById;
import com.netcracker.edu.searcher.person.SearchBySurname;
import org.apache.log4j.Logger;

public class PersonStorage extends AbstractRep<Person> {
    final static Logger logger = Logger.getLogger(PersonStorage.class);

    public PersonStorage() {
        this(1);
    }

    /**
     * Class constructor
     * @param arrSize size of PersonStorage
     */
    public PersonStorage(int arrSize) {
        arr = new Person[arrSize];
    }


    /**
     * Deletes Person from PersonStorage by his ID
     * @param id
     */
    public void deletePerson(UUID id) {
        UUID tmp = null;
        int i;
        Person[] tmpArr = toArray(new Person[0]);
        for (i = 0; i < tail; i++) {
            if (tmpArr[i].getId().equals(id)) {
                tmp = id;
                break;
            }
        }

        if (tmp != null) {
            System.arraycopy(arr, i + 1, arr, i, tail - i);
            tail--;
        }
    }

    /**
     * Gets Person by ID
     * @param id
     * @return Person
     */
    public Person getPersonById(UUID id) {
        Person tmp = null;
        Person[] tmpArr = toArray(new Person[0]);
        for (int i = 0; i < tail; i++) {
            if (tmpArr[i].getId().equals(id)) {
                tmp = tmpArr[i];
                break;
            }
        }
        return tmp;
    }

    @Override
    protected Repository<Person> getRepositoryInstance() {
        return new PersonStorage();
    }

    public Repository<Person> searchBySurname(String surname) {
        return search(new SearchBySurname(), surname);
    }

    public Repository<Person> searchByAge(int age) {
        return search(new SearchByAge(), age);
    }

    public Repository<Person> searchById(UUID id) {
        return search(new SearchById(), id);
    }


    public void sortByAge() {
        Configurator.getInstance().getSorter().sort(getArr(), new SortedByAge());
    }

    public void sortById() {
        Configurator.getInstance().getSorter().sort(getArr(), new SortedById());
    }

    public void sortBySurname() {
        Configurator.getInstance().getSorter().sort(getArr(), new SortedBySurname());
    }

    public void print() {
        for (Person i : toArray(new Person[0])) {
            if (i == null) {
                break;
            }
            System.out.println("ID: " + i.getId() + "; Surname: " + i.getSurname() +
                    "; Age: " + i.getAge());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        PersonStorage other = (PersonStorage) obj;
        return tail == other.tail && Arrays.equals(arr, other.arr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + tail;
        return result;
    }
}
