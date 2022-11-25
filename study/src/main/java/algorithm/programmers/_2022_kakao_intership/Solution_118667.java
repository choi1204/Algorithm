package algorithm.programmers._2022_kakao_intership;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class Solution_118667 {
    class MyQueue {
        Queue<Long> queue;
        long sum;

        public MyQueue() {
            this.queue = new LinkedList<>();
            this.sum = 0;
        }
        public void add(long value) {
            queue.add(value);
            sum += value;
        }
        public long pop() {
            long value = 0;
            if (!queue.isEmpty()) {
                value = queue.poll();
                sum -= value;
            }
            return value;
        }

    }
    public int solution(int[] queue1, int[] queue2) {

        MyQueue firstQueue = new MyQueue();
        MyQueue secondQueue = new MyQueue();
        int answer = 0;
        for (int i = 0; i < queue1.length; i++) {
            firstQueue.add(queue1[i]);
            secondQueue.add(queue2[i]);
        }
        if ((firstQueue.sum + secondQueue.sum) % 2 != 0) {
            return -1;
        }
        while (firstQueue.sum != secondQueue.sum) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            answer++;
            if (firstQueue.sum > secondQueue.sum) {
                secondQueue.add(firstQueue.pop());
            } else {
                firstQueue.add(secondQueue.pop());
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_118667 sol = new Solution_118667();
        sol.solution(new int[] {3,2,7,2}, new int[]{4,6,5,1});
    }
}
