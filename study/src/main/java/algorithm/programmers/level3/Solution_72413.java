package algorithm.programmers.level3;

import java.util.Arrays;

/**
 * 합승 택시 요금
 * https://school.programmers.co.kr/learn/courses/30/lessons/72413
 */
public class Solution_72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int value = fares[i][2];

            graph[start][end] = value;
            graph[end][start] = value;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int c = 1 ; c < n + 1; c++) {
                    graph[j][c] = Math.min(graph[j][c], graph[j][i]
                            + graph[i][c]);
                }
            }
        }

        int answer = graph[s][a] + graph[s][b];

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return answer;

    }
}
