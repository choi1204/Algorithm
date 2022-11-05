package algorithm.programmers.level3;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 이중 우선순위큐
 */
public class Solution_42628 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Queue<Integer> minPq = new PriorityQueue<>();
        Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("D")) {
                if (minPq.isEmpty() || maxPq.isEmpty()) {
                    continue;
                }
                if (split[1].equals("1")) {
                    Integer max = maxPq.poll();
                    minPq.remove(max);
                } else {
                    Integer min = minPq.poll();
                    maxPq.remove(min);
                }
            } else {
                int value = Integer.parseInt(split[1]);
                minPq.add(value);
                maxPq.add(value);
            }
        }
        if (!minPq.isEmpty() && !maxPq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }
}
