package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747
 * HIndex
 */
public class Solution_42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for ( int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return answer;
    }
}
