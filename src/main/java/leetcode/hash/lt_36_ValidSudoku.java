package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @Author: zhangjianwu
 * @Date: 2022/3/12 17:51
 * @Desc:
 **/
public class lt_36_ValidSudoku {
    public static void main(String[] args) {
        char[][] arr =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//            {{'5','3','.','.','7','.','.','.','.'}
//            ,{'6','.','.','1','9','5','.','.','.'}
//            ,{'.','9','8','.','.','.','.','6','.'}
//            ,{'8','.','.','.','6','.','.','.','3'}
//            ,{'4','.','.','8','.','3','.','.','1'}
//            ,{'7','.','.','.','2','.','.','.','6'}
//            ,{'.','6','.','.','.','.','2','8','.'}
//            ,{'.','.','.','4','1','9','.','.','5'}
//            ,{'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = isValidSudoku(arr);
        System.out.println(validSudoku);
    }



    static class ij {
        private final int i;
        private final int j;

        ij(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ij ij = (ij) o;
            return i == ij.i && j == ij.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
    public static boolean isValidSudoku(char[][] board) {
        //行
        HashMap<Integer, HashSet<Character>> rows= new HashMap<>();
        //列
        HashMap<Integer, HashSet<Character>> cols= new HashMap<>();
        //小正方形
        HashMap<Integer, HashSet<Character>> square= new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (rows.get(i) != null) {
                        if (rows.get(i).contains(board[i][j])) {
                            return false;
                        } else {
                            rows.get(i).add(board[i][j]);
                        }
                    } else {
                        HashSet<Character> set = new HashSet<>();
                        set.add(board[i][j]);
                        rows.put(i, set);
                    }
                    if (cols.get(j) != null) {
                        if (cols.get(j).contains(board[i][j])) {
                            return false;
                        } else {
                            cols.get(j).add(board[i][j]);
                        }
                    } else {
                        HashSet<Character> set = new HashSet<>();
                        set.add(board[i][j]);
                        cols.put(j, set);
                    }
                    int key=i/3*3+j/3;
                    if (square.containsKey(key)) {
                        if (square.get(key).contains(board[i][j])) {
                            return false;
                        } else {
                            square.get(key).add(board[i][j]);
                        }
                    } else {
                        HashSet<Character> set = new HashSet<>();
                        set.add(board[i][j]);
                        square.put(key, set);
                    }
                }
            }
        }
        return true;
    }
}








