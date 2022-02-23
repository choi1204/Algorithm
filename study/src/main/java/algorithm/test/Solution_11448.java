package algorithm.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_11448 {

    public static class Node implements Comparable<Node> {
        int V;
        int cost;
        Node(int v, int cost) {
            this.V=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost-this.cost;
        }
    }
    public static int[] solution(int n, int[] passenger, int[][] train) {
        List<Node>[] map = new ArrayList[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] i : train) {
            map[i] = passenger[i[1] - 1];
        }
        boolean[] visit = new boolean[n + 1];
        pq.add(new Node(1,  passenger[0]));
        int lastNode = 1;
        int lastValue = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.V;
            if(visit[v]) {
                continue;
            }
            if (lastValue < node.cost) {
                lastNode = v;
                lastValue = node.cost;
            } else if (lastValue == node.cost) {
                lastNode = Math.max(lastNode,v);
            }
            visit[v] = true;
            for(int i = 1; i<= n ; i++) {
                if(visit[i] || map[v][i] == 0) {
                    continue;
                }
                pq.add(new Node(i,node.cost + passenger[i - 1]));
            }
        }
        int[] answer = {lastNode, lastValue};

        return answer;
    }

    public static void main(String[] args) {
        int n =6;
        int[] passenger = {1,1,2,3,4};
        int[][] train = {{1,2},{1,3},{1,4},{1,5}};
        solution(n,passenger,train);
    }
}
