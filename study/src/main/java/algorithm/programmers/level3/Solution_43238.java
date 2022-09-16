package algorithm.programmers.level3;

import java.util.Arrays;

/**
 * 입국 심사
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */

public class Solution_43238 {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length - 1] * (long)n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = Math.min(mid, answer);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
