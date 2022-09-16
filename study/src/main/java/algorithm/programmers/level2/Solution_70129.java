package algorithm.programmers.level2;

/**
 * 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

public class Solution_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int beforeSize = s.length();
            s = s.replace("0", "");
            int afterSize = s.length();
            answer[1] += beforeSize - afterSize;
            s = Integer.toString(afterSize, 2);
            answer[0]++;
        }

        return answer;
    }
}
