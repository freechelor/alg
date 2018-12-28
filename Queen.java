package alg.rcs;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {
    static void getCombi(boolean[][] b, int row, ArrayList<boolean[][]> res) {
        if(row==b.length) {
            res.add(b.clone());
            //return;
            fill(b,false);
        }
        for(int c=0; c<b[0].length; c++) {
            if(checkValid(b, row, c)) {
                b[row][c] = true;
                getCombi(b, row+1, res);
            }
        }
    }

    static boolean checkValid(boolean[][] b, int row, int col) {
        for(int r=0; r<row; r++) {
            if(b[r][col]) {
                return false;
            }
        }
        for(int r=0; r<row; r++) {
            for(int c=0; c<b[0].length; c++) {
                if(b[r][c]) {
                    if(Math.abs(row-r)==Math.abs(col-c)) return false;
                }
            }
        }
        return true;
    }

    static void fill(boolean[][] arr, boolean v) {
        for(int r=0; r<arr.length; r++) {
            Arrays.fill(arr[r], v);
        }
    }

    static void print(boolean[][] arr) {
        for(int r=0; r<arr.length; r++) {
            for(int c=0; c<arr[0].length; c++) {
                System.out.print((arr[r][c])? "T" + "  ": "F" + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        boolean[][] board = new boolean[8][8];
        fill(board, false);
        ArrayList<boolean[][]> result = new ArrayList<boolean[][]>();
        getCombi(board, 0, result);
        System.out.println(result.size());
        for(boolean[][] r : result) {
            print(r);
        }
    }
}
