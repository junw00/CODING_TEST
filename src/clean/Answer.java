package clean;

import java.util.*;

public class Answer {
    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};  // 방향을 수정했습니다.

        int dir = 0;  // 초기 방향은 오른쪽(동쪽)
        int row = 0;
        int col = 0;

        for (int i = 0; i < k; i++) {
            // 다음 위치를 계산합니다.
            int nextRow = row + dy[dir];
            int nextCol = col + dx[dir];

            // 벽이나 장애물에 부딪히면 방향을 바꿉니다.
            if (nextCol < 0 || nextCol >= board[0].length || nextRow < 0 || nextRow >= board.length || board[nextRow][nextCol] == 1) {
                dir = (dir + 1) % 4;  // 시계 방향으로 90도 회전
            } else {
                // 이동이 가능하면 실제로 이동합니다.
                row = nextRow;
                col = nextCol;
            }
        }

        answer[0] = row;
        answer[1] = col;
        return answer;
    }

    public static void main(String[] args) {
        Answer T = new Answer();
        int[][] arr1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr1, 10)));

        int[][] arr2 = {
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr2, 20)));

        int[][] arr3 = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
