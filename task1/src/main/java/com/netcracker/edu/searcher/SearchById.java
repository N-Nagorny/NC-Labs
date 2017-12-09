/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.edu.searcher;

import com.netcracker.edu.task1.Person;

import java.util.UUID;

public class SearchById implements PersonSearcher {

    @Override
    public boolean isMatchTo(Person person, Object id) {
        return (person.getId().equals(id));
    }
}
