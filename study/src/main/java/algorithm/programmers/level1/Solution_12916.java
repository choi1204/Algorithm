package algorithm.programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class Solution_12916 {
    boolean solution(String s) {
        int numP = 0;
        int numY = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                numP++;
            } else if (c == 'Y' || c =='y') {
                numY++;
            }
        }

        return numP == numY;
    }
}
