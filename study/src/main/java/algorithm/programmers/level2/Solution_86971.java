package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 전력망을 둘로 나누기
 */
public class Solution_86971 {
    public int solution(int n, int[][] wires) {
        List<Integer>[] list = new ArrayList[n + 1];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int count1 = dfs(wire[0], wire[1], list, new boolean[n + 1]);
            int count2 = dfs(wire[1], wire[0], list, new boolean[n + 1]);
            int gap = Math.abs(count1 - count2);
            answer = Math.min(gap, answer);
        }
        return answer;
    }

    private int dfs(int v1, int v2, List<Integer>[] list, boolean[] visit) {
        visit[v1] = true;
        int sum = 1;
        for (int i = 0; i < list[v1].size(); i++) {
            int next = list[v1].get(i);
            if (next != v2 && !visit[next]) {
                sum += dfs(next, v2, list, visit);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_86971 solution = new Solution_86971();
        solution.solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }
}
