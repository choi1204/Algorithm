package algorithm.programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Solution_42626 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int food : scoville) {
            pq.add(food);
        }
        while (pq.size() > 1 && pq.peek() < K) {
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.add(food1 + food2 * 2);
            answer++;
        }
        if (pq.isEmpty() || pq.peek( ) < K) {
            answer = - 1;
        }
        return answer;
    }
}
