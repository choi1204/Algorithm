package algorithm.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속카메라
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class Solution_42884 {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, Comparator.comparingInt((int[] route) -> route[1]));
        int cam = routes[0][1];
        for (int[] route : routes) {
            if (cam < route[0]) {
                answer++;
                cam = route[1];
            }
        }
        return answer;
    }
}
