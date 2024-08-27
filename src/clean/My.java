package clean;

import java.util.*;

public class My {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int dir = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < k; i++) {

            if(col == board[0].length - 1 && dir == 0) {
                dir++;
            }else if(row == board.length - 1 && dir == 1) {
                dir++;
            }else if(col == 0  && dir == 2) {
                dir++;
            }else if(row == 0 && dir == 3) {
                dir = 0;
            }else if (board[row][col + dx[dir]] == 1 && dir == 0) {
                dir++;
            }else if (board[row + dy[dir]][col] == 1 && dir == 1) {
                dir++;
            }else if (board[row][col + dx[dir]] == 1 && dir == 2) {
                dir++;
            }else if (board[row + dy[dir]][col] == 1 && dir == 3) {
                dir = 0;
            }else {
                row += dy[dir];
                col += dx[dir];
            }
        }
        System.out.println(row + " " + col);


        return answer;
    }

    public static void main(String[] args){
        My T = new My();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
