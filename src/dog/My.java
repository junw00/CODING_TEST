package dog;

public class My {
    public int solution(int[][] board) {
        int answer = 0;
        int dir = 0;
        int dogDir = 0;

        int dogX = 0;
        int dogY = 0;
        int hyunsooX = 0;
        int hyunsooY = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 2) {
                    hyunsooY = i;
                    hyunsooX = j;
                }else if(board[i][j] == 3) {
                    dogY = i;
                    dogX = j;
                }
            }
        }

        int cnt = 0;
        while(cnt < 10000) {
            cnt++;

            //강아지 위치
            int x = dogX + dx[dogDir];
            int y = dogY + dy[dogDir];

            int x1 = hyunsooX + dx[dir];
            int y1 = hyunsooY + dy[dir];

            if(x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1 || board[y][x] != 0) {
                dogDir = (dogDir + 1) % 4;
            }else if (x1 < 0 || y1 < 0 || x1 > board[0].length - 1 || y1 > board.length - 1 || board[y1][x1] != 0) {
                dir = (dir + 1) % 4;
            }else {
                board[dogY][dogX] = 0;
                board[y][x] = 3;
                dogY = y;
                dogX = x;

                board[hyunsooY][hyunsooX] = 0;
                board[y1][x1] = 2;
                hyunsooY = y1;
                hyunsooX = x1;
                if (x == x1 && y == y1) {
                    return cnt;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        My T = new My();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
