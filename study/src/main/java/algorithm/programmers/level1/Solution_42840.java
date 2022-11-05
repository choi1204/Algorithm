package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Solution_42840 {
    public int[] solution(int[] answers) {
        int patterns[][] = new int[][] {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} };
        int pointTable[] = new int[3];
        List<Integer> answer = new ArrayList<>();
        int maxPoint = 0;
        for (int i = 0; i < patterns.length; i++) {
            pointTable[i] = solve(answers, patterns[i]);
            maxPoint = Math.max(maxPoint, pointTable[i]);
        }
        for (int i = 0; i < pointTable.length; i++) {
            if (pointTable[i] == maxPoint) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    public int solve(int[] answer, int[] pattern) {
        int point = 0;
        for (int i = 0; i < answer.length; i++) {
            int patternIndex = i % pattern.length;
            if (answer[i] == pattern[patternIndex]) {
                point++;
            }
        }
        return point;
    }
}
