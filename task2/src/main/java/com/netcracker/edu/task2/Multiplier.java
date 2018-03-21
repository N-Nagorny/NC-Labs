package com.netcracker.edu.task2;

public class Multiplier {

    private int aRows;
    private int aCols;

    private int bRows;
    private int bCols;

    private int[][] A;
    private int[][] B;
    private int[][] C;

    public Multiplier(int[][] A, int[][] B) {
        this.A = A;
        this.B = B;

        aRows = A.length;
        aCols = A[0].length;

        bRows = B.length;
        bCols = B[0].length;
        C = new int[aRows][bCols];
    }

    public int[][] multiply() throws InterruptedException {
        WorkerThread [][] Threads = new WorkerThread[aRows][bCols];

        for (int i = 0; i < aRows; i++){
            for (int j = 0; j < bCols; j++){
                int[] aRow = new int [aCols];
                int[] bCol = new int [bRows];
                for (int m = 0; m < aCols ; m++) {
                    aRow[m] = A[i][m];
                }
                for (int m = 0; m < bRows ; m++) {
                    bCol[m] = B[m][j];
                }
                Threads[i][j] = new WorkerThread(aRow, bCol);
                Threads[i][j].start();
            }
        }

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                Threads[i][j].join();
            }
        }

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                C[i][j] = Threads[i][j].getValue();
            }
        }
        return C;
    }
}
