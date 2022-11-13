package algorithm.programmers.level3;


/**
 * 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Solution_49191 {

    public int solution(int n, int[][] results) {
        int[][] graph =  new int[n + 1][n + 1];
        int answer = 0;
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        floyd(graph);
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }
                count++;
            }
            if (count == n -1) {
                answer++;
            }
        }
        return answer;
    }

    public void floyd(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < graph.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
