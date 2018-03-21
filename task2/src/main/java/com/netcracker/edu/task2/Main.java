package com.netcracker.edu.task2;

public class Main {
    public static int [][] A = { {1, 4},
                                 {2, 5},
                                 {3, 6}};

    public static int [][] B = { {8, 7, 6},
                                 {5, 4, 3}};

    public static void main(String[] args) throws InterruptedException {
        Multiplier multiplier = new Multiplier(A, B);
        int [][] C = multiplier.multiply();

        for (int i = 0; i<C.length; i++){
            for (int j=0; j<C[0].length; j++){
                System.out.println("["+i+","+j+"] = "+C[i][j]);
            }
        }
    }
}
