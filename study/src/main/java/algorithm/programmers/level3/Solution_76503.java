package algorithm.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Solution_76503 {
    long answer;
    boolean[] visit;
    List<Integer>[] children;
    long[] longA;

    public long solution(int[] a, int[][] edges) {
        this.answer = 0;
        this.visit = new boolean[a.length];
        this.children = new ArrayList[a.length];
        this.longA = new long[a.length];

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            children[i] = new ArrayList<>();
            longA[i] = a[i];
        }
        if (sum != 0) {
            return -1;
        }
        for (int[] edge : edges) {
            children[edge[0]].add(edge[1]);
            children[edge[1]].add(edge[0]);
        }

        dfs(0);
        return answer;
    }

    public long dfs(int v) {
        this.visit[v] = true;

        for (int i = 0; i < children[v].size(); i++) {
            int next = children[v].get(i);
            if (!visit[next]) {
                longA[v] += dfs(next);
            }
        }

        return longA[v];
    }
}
