package com.netcracker.edu.task1;

import com.netcracker.edu.searcher.Searcher;
import com.netcracker.edu.sorter.Sorter;
import org.apache.log4j.Logger;

import java.util.*;

public abstract class AbstractRep<T> implements Repository<T> {

    final static Logger logger = Logger.getLogger(PersonStorage.class);
    protected Object[] arr;
    protected int tail = 0;

    /**
     * Adds T into AbstractRep
     * @param t
     */
    @Override
    public void addItem(T t) {
        if (arr[arr.length - 1] != null)  {
            Object[] newArr = new Object[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
            logger.info("Array size: " + arr.length);
        }
        if (tail != 0) {
            arr[tail++] = t;
        }
        else {
            arr[tail] = t;
            tail++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private T t = (T)arr[0];
            private int last = 0;

            @Override
            public boolean hasNext() {
                return last < tail;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();

                T cur = t;
                t = (T)arr[last++];
                return cur;
            }
        };
    }
    protected Repository<T> search(Searcher<T> ps, Object object) {
        logger.debug("search() was called");
        Repository<T> pStorage = getRepositoryInstance();
        //T[] tmpArr = toArray(new T[0]);
        for (int i = 0; i < tail; i++) {
            if (ps.isMatchTo((T)arr[i], object)) {
                pStorage.addItem((T)arr[i]);
            }
        }
        return pStorage;
    }

    abstract protected Repository<T> getRepositoryInstance();
    abstract public void print();
    /**
     * Gets number of last filled element in storage
     * @return number of last filled element
     */

    public int getTail() {
        return tail;
    }
    public Object[] getArr() {
        return arr;
    }

//    /**
//     * Class constructor
//     * @param arr array of Person
//     * @param tail number of last filled element
//     */
//    public AbstractRep(T[] arr, int tail) {
//        this.arr = arr;
//        this.tail = tail;
//    }


    public <T> T[] toArray(T[] a) {
        if (a.length < tail)
            return (T[]) Arrays.copyOf(arr, tail, a.getClass());
        System.arraycopy(arr, 0, a, 0, tail);
        if (a.length > tail)
            a[tail] = null;
        return a;
    }
}
