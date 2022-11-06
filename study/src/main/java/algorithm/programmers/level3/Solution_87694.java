package algorithm.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아이템 줍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */
public class Solution_87694 {
    final int[] dy = {1, 0, -1, 0};
    final int[] dx = {0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] sideMap = getSideMap(rectangle);
        int answer = bfs(sideMap, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }

    private int bfs(boolean[][] sideMap, int x, int y, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[104][104];
        queue.add(new int[]{y, x, 0});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int a = 1;
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (visit[nextY][nextX] || !sideMap[nextY][nextX]) {
                    continue;
                }
                if (nextY == itemY && nextX == itemX) {
                    return now[2] + 1;
                }

                visit[nextY][nextX] = true;
                queue.add(new int[]{nextY, nextX, now[2] + 1});
            }
        }
        return -1;
    }

    public boolean[][] getSideMap(int[][] rectangle) {
        boolean[][] map = getMap(rectangle);

        for (int[] point : rectangle) {
            int y1 = point[1] * 2;
            int x1 = point[0] * 2;
            int y2 = point[3] * 2;
            int x2 = point[2] * 2;
            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    map[y][x] = false;
                }
            }
        }
        return map;
    }

    private boolean[][] getMap(int[][] rectangle) {
        boolean[][] map = new boolean[104][104];
        for (int[] point : rectangle) {
            int y1 = point[1] * 2;
            int x1 = point[0] * 2;
            int y2 = point[3] * 2;
            int x2 = point[2] * 2;
            for (int y = y1; y <= y2; y++) {
                map[y][x1] = true;
                map[y][x2] = true;
            }
            for (int x = x1; x <= x2; x++) {
               map[y1][x] = true;
               map[y2][x] = true;
            }
        }
        return map;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
        Solution_87694 sol = new Solution_87694();
        System.out.println(sol.solution(arr, 1, 4, 6, 3));
    }
}
