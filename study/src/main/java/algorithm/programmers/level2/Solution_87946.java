package algorithm.programmers.level2;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Solution_87946 {
    static int answer;

    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        dfs(k, dungeons, visit, 0, 0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, boolean[] visit, int depth, int count) {
        if (depth == dungeons.length) {
            answer = Math.max(count, answer);
            return;
        }
        dfs(k, dungeons, visit, depth + 1, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] || k < dungeons[i][0]) {
                continue;
            }
            visit[i] = true;
            dfs(k - dungeons[i][1], dungeons, visit, depth + 1, count + 1);
            visit[i] = false;
        }
    }
}
