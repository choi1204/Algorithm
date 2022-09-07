package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 빛의 경로 싸이클
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */
public class Solution_86052 {
    static int r;
    static int c;
    public int[] solution(String[] grid) {
        r = grid.length;
        c = grid[0].length();
        boolean[][][] visit = new boolean[4][r][c];
        List<Integer> answer = new ArrayList<>();

        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (!visit[d][i][j]) {
                        answer.add(play(grid, visit, d, i, j));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int play(String[] grid, boolean[][][] visit,
                    int d, int x, int y) {

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int count = 0;
        while (true) {
            if (visit[d][x][y]) {
                break;
            }
            visit[d][x][y] = true;
            count++;
            if (grid[x].charAt(y) == 'R') {
                d = (d + 1) % 4;
            } else if (grid[x].charAt(y) == 'L') {
                d = (d + 3) % 4;
            }
            x = (x + dx[d] + r) % r;
            y = (y + dy[d] + c) % c;
        }
        return count;
    }
}
