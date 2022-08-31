package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class Solution_42596 {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }

        int day = 0;
        int index = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int progress = queue.peek() + day * speeds[index];
            if (progress >= 100) {
                queue.poll();
                index++;
                count++;
            } else {
                if (count != 0) {
                    answer.add(count);
                    count = 0;
                }
                day++;
            }
        }
        if (count != 0) {
            answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
