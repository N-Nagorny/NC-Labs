package com.netcracker.edu.task1;

import java.util.*;

import com.netcracker.edu.comparator.SortedByAge;
import com.netcracker.edu.comparator.SortedById;
import com.netcracker.edu.comparator.SortedBySurname;
import com.netcracker.edu.config.Configurator;
import com.netcracker.edu.searcher.PersonSearcher;
import com.netcracker.edu.searcher.SearchByAge;
import com.netcracker.edu.searcher.SearchById;
import com.netcracker.edu.searcher.SearchBySurname;
import com.netcracker.edu.sorter.PersonSorter;

public class PersonStorage implements Repository<Person> {

    private Person[] arr;
    private int tail = 0;

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
     * Class constructor
     * @param arr array of Person
     * @param tail number of last filled element
     */
    public PersonStorage(Person[] arr, int tail) {
        this.arr = arr;
        this.tail = tail;
    }
    /**
     * Gets number of last filled element in storage
     * @return number of last filled element
     */

    public int getTail() {
        return tail;
    }
    public Person[] getArr() {
        return arr;
    }

    /**
     * Adds Person into PersonStorage
     * @param person
     */
    @Override
    public void addItem(Person person) {
        if (arr[arr.length - 1] != null)  {
            Person[] newArr = new Person[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        if (tail != 0) {
            arr[tail++] = person;
        }
        else {
            arr[tail] = person;
            tail++;
        }

    }

    /**
     * Deletes Person from PersonStorage by his ID
     * @param id
     */
    public void deletePerson(UUID id) {
        UUID tmp = null;
        int i;
        for (i = 0; i < tail; i++) {
            if (arr[i].getId().equals(id)) {
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
        for (int i = 0; i < tail; i++) {
            if (arr[i].getId().equals(id)) {
                tmp = arr[i];
                break;
            }
        }
        return tmp;
    }

    private PersonStorage search(PersonSearcher ps, Object object) {
        PersonStorage pStorage = new PersonStorage(1);
        for (int i = 0; i < tail; i++) {
            if (ps.isMatchTo(arr[i], object)) {
                pStorage.addItem(arr[i]);
            }
        }
        return pStorage;
    }

    public PersonStorage searchBySurname(String surname) {
        return search(new SearchBySurname(), surname);
    }

    public PersonStorage searchByAge(int age) {
        return search(new SearchByAge(), age);
    }

    public PersonStorage searchById(UUID id) {
        return search(new SearchById(), id);
    }

    private void sort(Comparator<Person> comparator,PersonSorter sorter) {
        PersonStorage ps = sorter.sort(this, comparator);
        this.arr = ps.getArr();
        this.tail = ps.getTail();
        }

    public void sortByAge() {
        sort(new SortedByAge(), Configurator.getInstance().getSorter());
    }

    public void sortById() {
        sort(new SortedById(), Configurator.getInstance().getSorter());
    }

    public void sortBySurname() {
        sort(new SortedBySurname(), Configurator.getInstance().getSorter());
    }

    public void print() {
        for (Person i : arr) {
            if (i == null) {
                break;
            }
            System.out.println("ID: " + i.getId() + "; Surname: " + i.getSurname() +
                    "; Age: " + i.getAge());
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            private Person person = arr[0];
            private int last = 0;

            @Override
            public boolean hasNext() {
                return last < tail;
            }

            @Override
            public Person next() {
                if(!hasNext()) throw new NoSuchElementException();

                Person cur = person;
                person = arr[last++];
                return cur;
            }
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        
        PersonStorage other = (PersonStorage) obj;
        if (tail != other.tail)
            return false;
        return Arrays.equals(arr, other.arr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + tail;
        return result;
    }
}
