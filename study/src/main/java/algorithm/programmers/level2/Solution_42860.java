package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 조이스틱
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Solution_42860 {

    public int solution(String name) {
        int nameSize = name.length();
        char[] defaultName = new char[nameSize];
        int move = nameSize - 1;
        Arrays.fill(defaultName, 'A');
        int answer = 0;
        int index;

        for (int i = 0; i < nameSize; i++) {
            answer += Math.min(name.charAt(i) - defaultName[i], 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < nameSize && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move , Math.min(i * 2 + nameSize - index, (nameSize - index) * 2 + i));
        }
        return answer + move;
    }

    public static void main(String[] args) {
        Solution_42860 solution = new Solution_42860();
        solution.solution("AAABBBBBBBAA");
    }
}
