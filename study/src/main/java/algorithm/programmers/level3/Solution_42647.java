package algorithm.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Solution_42647 {

    public int solution(int[][] jobs) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        int nowTime = 0;
        int index = 0;
        int count = 0;
        int waitingTime = 0;
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= nowTime) {
                pq.add(jobs[index++]);
            }
            if (pq.isEmpty()) {
                nowTime = jobs[index][0];
            } else {
                int[] job = pq.poll();
                count++;
                waitingTime += job[1] + nowTime - job[0];
                nowTime += job[1];
            }
        }
        return (int )waitingTime / jobs.length;
    }
}
