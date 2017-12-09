package com.netcracker.edu.searcher;

import com.netcracker.edu.task1.Person;

public interface PersonSearcher {
    boolean isMatchTo(Person person, Object object);
}
