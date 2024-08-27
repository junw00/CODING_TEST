package seat;

import java.util.*;
public class My {
    public int[] solution(int c, int r, int k){
        int[][] seats = new int[r][c];
        int[] answer = {1, 0};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int dir = 0;
        int[] currentSeat = {r, 0};
        int i = 1;
        int cnt = 0;
        if(k > r * c) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        while (cnt < k) {
            cnt++;
            int x = currentSeat[1] + dx[dir];
            int y = currentSeat[0] + dy[dir];

            if (x < 0 || y < 0 || x > seats[0].length - 1 || y > seats.length - 1 || seats[y][x] != 0) {
                dir = (dir + 1) % 4;
                cnt--;
            } else {
                seats[y][x] = i++;

                currentSeat[1] += dx[dir];
                currentSeat[0] += dy[dir];

                answer[0] += dx[dir];
                answer[1] -= dy[dir];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        My T = new My();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
