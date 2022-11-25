package algorithm.programmers._2022_kakao_intership;

import java.util.*;

public class Solution_118669 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<int []>[] graph = new ArrayList[n + 1];
        int[] answer = {0, Integer.MAX_VALUE};
        Set<Integer> summitSet = new HashSet<>();
        Set<Integer> gateSet = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        for (int summit : summits) {
            summitSet.add(summit);
        }
        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int cost = path[2];
            if (!gateSet.contains(end) && !summitSet.contains(start)) {
                graph[start].add(new int [] {end, cost});
            }
            if (!summitSet.contains(end) && !gateSet.contains(start)) {
                graph[end].add(new int[] {start, cost});
            }
        }

        int[] visit = new int[n + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.add(new int[] {gate, 0});
        }


        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visit[now[0]] <= now[1]) {
                continue;
            }
            visit[now[0]] = now[1];
            if (summitSet.contains(now[0])) {
                continue;
            }
            for (int[] node : graph[now[0]]) {
                    int intensity = Math.max(now[1], node[1]);
                    if (intensity <= visit[node[0]]) {
                        pq.add(new int[]{node[0], intensity});
                    }
                }
            }

        for (int summit : summits) {
            if (visit[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = visit[summit];
            } else if (visit[summit] == answer[1] && summit < answer[0]) {
                answer[0] = summit;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_118669 sol = new Solution_118669();
        sol.solution(6, new int[][] {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[] {1, 3}, new int[] {5});
    }
}
