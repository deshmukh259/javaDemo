package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ChaseBoard {


    public static void main(String[] args) {

        List<List<Integer>> board = new ArrayList<>();
        List<Integer> f1 = new ArrayList<>();
        f1.add(0);
        f1.add(0);
        board.add(f1);
        f1 = new ArrayList<>();
        f1.add(1);
        f1.add(0);
        board.add(f1);
        System.out.println(solve(board));
    }

    // Complete the solve function below.
    static String solve(List<List<Integer>> board) {
        int f = 0;
        for (int i = 0; i < board.size() - 1; i++)
            for (int j = 0; j < board.size() - 1; j++) {
                f = board.get(i).get(j) ^ board.get(i).get(j + 1);
                if (f == 0) {
                    return "No";
                }
                f = 0 ^ board.get(i + 1).get(j);
                if (f == 0) {
                    return "No";
                }
            }
        return "Yes";
    }
}
