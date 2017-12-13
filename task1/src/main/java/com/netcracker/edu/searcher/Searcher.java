package com.netcracker.edu.searcher;

import com.netcracker.edu.task1.Person;

public interface Searcher<T> {
    boolean isMatchTo(T t, Object object);
}
