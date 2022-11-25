package algorithm.programmers.pccp;
/**
 * pccp 모의고사 2
 */
public class Solution_2 {
    int answer;
    public int solution(int[][] ability) {
        int n = ability.length;
        int m = ability[0].length;
        boolean[] visit = new boolean[ability.length];
        dfs(0, 0, ability, visit);
        return answer;
    }
    public void dfs(int depth, int sum, int[][] ability, boolean[] visit) {
        if (depth == ability[0].length) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, sum + ability[i][depth], ability, visit);
                visit[i] = false;
            }
        }
    }
}
