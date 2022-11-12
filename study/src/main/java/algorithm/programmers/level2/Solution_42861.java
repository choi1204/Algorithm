package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 섬 연결하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
public class Solution_42861 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt((int[] v) -> v[2]));
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] node : costs) {
            int to = node[0];
            int from = node[1];
            int v = node[2];
            int toParent = find(to, parents);
            int fromParent = find(from, parents);

            if (toParent == fromParent) {
                continue;
            }
            answer += v;
            parents[toParent] = fromParent;
        }

        return answer;
    }

    private int find(int node, int[] parents) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node], parents);
    }

    private void union(int node1, int node2, int[] parents) {
        int parent1 = find(node1, parents);
        int parent2 = find(node2, parents);

        if (parent1 < parent2) {
            parents[parent1] = parent2;
        } else {
            parents[parent2] = parent1;
        }

    }
}
