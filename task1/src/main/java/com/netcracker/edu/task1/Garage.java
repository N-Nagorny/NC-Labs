package com.netcracker.edu.task1;

import java.util.*;

public class Garage implements Repository<Car> {
    private Car[] arr;
    private int tail = 0;

    public Garage() {
        this(1);
    }

    /**
     * Class constructor
     * @param arrSize size of PersonStorage
     */
    public Garage(int arrSize) {
        arr = new Car[arrSize];
    }

    /**
     * Class constructor
     * @param arr array of Person
     * @param tail number of last filled element
     */
    public Garage(Car[] arr, int tail) {
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
    public Car[] getArr() {
        return arr;
    }

    /**
     * Adds Person into PersonStorage
     * @param car
     */
    @Override
    public void addItem(Car car) {
        if (arr[arr.length - 1] != null)  {
            Car[] newArr = new Car[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        if (tail != 0) {
            arr[tail++] = car;
        }
        else {
            arr[tail] = car;
            tail++;
        }

    }

    /**
     * Deletes Person from PersonStorage by his ID
     * @param id
     */
    public void deleteCarById(UUID id) {
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
    public Car getCarById(UUID id) {
        Car tmp = null;
        for (int i = 0; i < tail; i++) {
            if (arr[i].getId().equals(id)) {
                tmp = arr[i];
                break;
            }
        }
        return tmp;
    }
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Car car = arr[0];
            private int last = 0;

            @Override
            public boolean hasNext() {
                return last < tail;
            }

            @Override
            public Car next() {
                if(!hasNext()) throw new NoSuchElementException();

                Car cur = car;
                car = arr[last++];
                return cur;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage)) return false;

        Garage cars = (Garage) o;

        if (tail != cars.tail) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arr, cars.arr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + tail;
        return result;
    }
}
