package com.netcracker.edu.task1;

public interface Repository<T> extends Iterable<T> {
    void addItem(T t);
}
