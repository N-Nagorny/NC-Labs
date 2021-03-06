package com.netcracker.edu.config;

import com.netcracker.edu.sorter.BubbleSort;
import com.netcracker.edu.sorter.InsertionSort;
import com.netcracker.edu.sorter.Sorter;

import java.util.ResourceBundle;

public class Configurator<T> {
    private static Configurator instance;

    public static synchronized Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }

    public synchronized Sorter<T> getSorter() {
        String sorter = "BubbleSort";
        ResourceBundle rb = ResourceBundle.getBundle("config");
        sorter = rb.getString("sorter");

        switch (sorter) {
            case "BubbleSort":
                return new BubbleSort();
            case "InsertionSort":
                return new InsertionSort();
            default:
                return new BubbleSort();
        }
    }
}