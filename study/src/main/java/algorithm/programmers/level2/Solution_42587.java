package algorithm.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프린터
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Solution_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        for (int num : priorities) {
            pq.offer(num);
        }

        while (!pq.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
