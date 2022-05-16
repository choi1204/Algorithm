package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.List;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 전화번호 목록
 */
public class Solution_42576 {

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int length = participant.length - 1;String answer = participant[length];
        for (int i = 0; i < length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] test1 = {"mislav", "stanko", "mislav", "ana"};
        String[] test2 = {"stanko", "ana", "mislav"};
        solution(test1, test2);
    }
}
