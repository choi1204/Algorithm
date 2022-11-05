package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
 */
public class Solution_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int nowWeight = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truck_weights) {
            while(true) {
                if (queue.size() == bridge_length) {
                    nowWeight -= queue.poll();
                } else {
                    answer++;
                    if (isAdd(queue, truck, weight, nowWeight)) {
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public boolean isAdd(Queue<Integer> queue, int truck, int weight, int nowWeight) {
        if (truck + nowWeight <= weight) {
            queue.add(truck);
            return true;
        } else {
            queue.add(0);
            return false;
        }
    }
}
