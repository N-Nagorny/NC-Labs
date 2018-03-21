package com.netcracker.edu.task2;

public class WorkerThread extends Thread{
    private int[] aRow;
    private int[] bCol;

    private int value = 0;

    public WorkerThread(int[] aRow, int[] bCol) {
        this.aRow = aRow;
        this.bCol = bCol;
    }

    public int getValue() {
        return value;
    }

    public void run() {
        value = 0;
        for (int i = 0; i < aRow.length; i++) {
                value += aRow[i] * bCol[i];
            }
    }
}

