package algorithm.programmers.level4;

import java.util.*;

/**
 * 징검다리
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
public class Solution_43236 {
    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;
        int answer = 0;

        Arrays.sort(rocks);

        while (left <= right) {
            int mid = (left + right) / 2;
            if (removeRock(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private int removeRock(int[] rocks, int mid, int distance) {
        int location = 0;
        int end = distance;
        int count = 0;

        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - location < mid) {
                count++;
                continue;
            }
            location = rocks[i];
        }
        if (end - location < mid) {
            count++;
        }
        return count;
    }

}
