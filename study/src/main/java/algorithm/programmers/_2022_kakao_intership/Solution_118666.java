package algorithm.programmers._2022_kakao_intership;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * 성격 유형 검사하기
 */
public class Solution_118666 {

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int size = survey.length;
        for (int i = 0; i < size; i++) {
            String type = survey[i];
            solveServey(choices, map, i, type);
        }
        answer.append(getResultType('R', 'T', map));
        answer.append(getResultType('C', 'F', map));
        answer.append(getResultType('J', 'M', map));
        answer.append(getResultType('A', 'N', map));
        return answer.toString();
    }

    private Character getResultType(char type1, char type2, Map<Character, Integer> map) {
        Integer type1Value = map.getOrDefault(type1, 0);
        Integer type2Value = map.getOrDefault(type2, 0);
        if (type1Value > type2Value) {
            return type1;
        } else if (type1Value.equals(type2Value)) {
            if (type1 > type2) {
                return type1;
            } else {
                return type2;
            }
        } else {
            return type2;
        }
    }

    private static void solveServey(int[] choices, Map<Character, Integer> map, int i, String type) {
        char worst = type.charAt(0);
        char good = type.charAt(1);

        switch (choices[i]) {
            case 1:
                map.put(worst, map.getOrDefault(worst, 0) + 3);
                break;
            case 2:
                map.put(worst, map.getOrDefault(worst, 0) + 2);
                break;
            case 3:
                map.put(worst, map.getOrDefault(worst, 0) + 1);
                break;
            case 4:
                break;
            case 5:
                map.put(good, map.getOrDefault(good, 0) + 1);
                break;
            case 6:
                map.put(good, map.getOrDefault(good, 0) + 2);
                break;
            case 7:
                map.put(good, map.getOrDefault(good, 0) + 3);
                break;
        }
    }

    public static void main(String[] args) {
        Solution_118666 sol = new Solution_118666();
        sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
}
