package algorithm.programmers.level3;


import java.util.*;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/49139
 * 가장 먼 노드
 */
public class Solution_49139 {

    public static int solution(int n, int[][] edge) {
        List<List<Integer>> list = init(n, edge);
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visit = new boolean[n];
        int[] dist = new int[n];
        dist[0] = 0;
        pq.add(0);
        visit[0] = true;
        dist = dijkstra(list, pq, visit, dist);
        int max = 0;
        int count = 0;
        for (int  node : dist) {
            if (max < node) {
                count = 1;
                max = node;
            } else if (max == node) {
                count++;
            }
        }
        return count;
    }

    static int[] dijkstra(List<List<Integer>> list, Queue<Integer> pq, boolean[] visit, int[] dist)  {

        while (!pq.isEmpty()) {
            int now = pq.poll();
            for (int index : list.get(now)) {
                if (!visit[index ]) {
                    dist[index] = dist[now] + 1;
                    visit[index] =true;
                    pq.add(index);
                }
            }
        }
        return dist;
    }
    static List<List<Integer>> init(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)  {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int node1 = edge[i][0] - 1;
            int node2 = edge[i][1] - 1;
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        return list;
    }

    public static void main(String[] args) {
        int n =6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(n, vertex);
    }
}
