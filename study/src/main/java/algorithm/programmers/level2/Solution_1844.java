package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 */
public class Solution_1844 {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private int bfs(int[][] maps) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int move = node[2];
            for (int i = 0; i < 4; i++) {
                int moveX = node[1] + dx[i];
                int moveY = node[0] + dy[i];
                if (moveX == maps[0].length - 1 && moveY == maps.length - 1) {
                    return move + 1;
                }
                if (!(moveX >= 0 && moveY >= 0 && moveX < maps[0].length && moveY < maps.length)) {
                    continue;
                }
                if (visit[moveY][moveX] || maps[moveY][moveX] == 0) {
                    continue;
                }
                visit[moveY][moveX] = true;
                queue.add(new int[]{moveY, moveX, move + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_1844 solution = new Solution_1844();
        solution.solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}});
    }
}
